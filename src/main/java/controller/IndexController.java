package controller;

import modele.Chanson;
import modele.FileModel;
import modele.Mp3Info;
import modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@SessionAttributes("utilisateur")
@RequestMapping("/")
public class IndexController {
    private final Service service = new Service();
    @Autowired
    ServletContext context;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(ModelMap model) throws Exception {
        Chanson[] songs = service.getSongs();
        model.addAttribute("chansons", songs);
        model.addAttribute("title", "Bienvenue KBH's Music");
//        ModelAndView       map  = new ModelAndView("page/home");
//        map.addObject("meilleuralbum",albums);
        return "page/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profil")
    public String profil(ModelMap model) {
//        ArrayList<BaseModele> albums = service.getMeilleurAlbum();
//        model.addAttribute("title", "Profil");
//        ModelAndView map = new ModelAndView("page/profil");
        model.addAttribute("title", "Profil");
        return "page/profil";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String admin(ModelMap model) {
//        ArrayList<BaseModele> albums = service.getMeilleurAlbum();
//        model.addAttribute("title", "Profil");
//        ModelAndView map = new ModelAndView("page/profil");
        // map.addObject("meilleuralbum",albums);
        return "page/admin";
    }


//    @RequestMapping(value = "favoris", method = RequestMethod.GET, path = "/index")
//    public String favoris(ModelMap model) throws Exception {
//        Album album = new Album();
//        album.setNom("paz");
//        model.addAttribute("album", album);
//        return "index";
//    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String       email    = request.getParameter("email");
        String       password = request.getParameter("password");
        ModelAndView index    = new ModelAndView("page/index");
        if (email != null && !email.equals("") && password != null && !password.equals("")) {
            try {
                Utilisateur  user = Service.login(email, password);
                ModelAndView map  = new ModelAndView("page/profil");
                session.setAttribute("utilisateur", user);
//                map.addObject("utilisateur", user);
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return index;
        }
        return index;
    }

    @RequestMapping(value = "/succes", method = RequestMethod.GET)
    public String success() {

        return "page/success";
    }

    @RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
    public ModelAndView fileUploadPage() {
        FileModel file = new FileModel();
        return new ModelAndView("page/profil", "command", file);
    }

    @RequestMapping(value = "/fileUploadPage", method = RequestMethod.POST)
    public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws Exception {
        if (result.hasErrors()) {
            return "/fileUploadPage";
        } else {
            MultipartFile multipartFile = file.getFile();
            String        path          = context.getRealPath("resources\\media") + File.separator;
            File          newfile       = new File(path + file.getFile().getOriginalFilename());
            FileCopyUtils.copy(file.getFile().getBytes(), newfile);
            String  fileName = multipartFile.getOriginalFilename();
            Mp3Info mp3Info  = new Mp3Info().extractMP3(newfile.getPath());
            model.addAttribute("fileName", fileName);
            model.addAttribute("infoMp3", mp3Info);

            return "page/profil";
        }
    }

    @RequestMapping(value = "/saveInfoMp3", method = RequestMethod.POST)
    public void saveInfoMp3(String path, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        service.saveFileUpload(path, utilisateur);
    }
//        @RequestMapping("/audio/{fileName:.+}")
//        public void downloadaudio( HttpServletRequest request,
//                                         HttpServletResponse response,
//                                         @PathVariable("fileName") String fileName)
//        {
//            String dataDirectory = request.getServletContext().getRealPath("/webapp/ressources/media/");
//            Path   file          = Paths.get(dataDirectory, fileName);
//            if (Files.exists(file))
//            {
//                response.setContentType("application/pdf");
//                response.addHeader("Content-Disposition", "attachment; filename="+fileName);
//                try
//                {
//                    Files.copy(file, response.getOutputStream());
//                    response.getOutputStream().flush();
//                }
//                catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
}

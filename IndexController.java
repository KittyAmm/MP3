package controller;

import modele.FileModel;
import modele.Mp3Info;
import modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.Service;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import modele.Chanson;
import modele.Menu;

@Controller
@SessionAttributes("utilisateur")
@RequestMapping("/")
public class IndexController {
    private final Service service = new Service();
    @Autowired
    ServletContext context;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(ModelMap model) throws Exception {
        Mp3Info[] songs = service.getSongs();
        model.addAttribute("chansons", songs);
        model.addAttribute("title", "Bienvenue KBH's Music");
        return "page/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profil")
    public String profil(ModelMap model) throws Exception {
        model.addAttribute("title", "Profil");
//        Playlist[] songs = service.getPlaylist();
//        model.addAttribute("playlists", songs);
        return "page/profil";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String admin(ModelMap model) throws Exception {
        Mp3Info[] songs = service.getSongs();
        model.addAttribute("chansons", songs);
        return "page/admin";
    }

    @RequestMapping(value = "uploadadmin", method = RequestMethod.POST)
    public String uploadAdmin(ModelMap model, @Validated FileModel file, BindingResult result, HttpSession session, String path) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            return admin(model);
        }
        String    upload = fileUpload(file, result, model, session);
        Mp3Info[] songs  = service.getSongs();
        model.addAttribute("chansons", songs);
        return admin(model);
    }

    @RequestMapping(value = "/saveInfoadmin", method = RequestMethod.POST)
    public String saveinfoadmin(String path, HttpSession session, ModelMap model) throws Exception {
        saveInfoMp3(path, session, model);
        return admin(model);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && !email.equals("") && password != null && !password.equals("")) {
            try {
                Utilisateur user = Service.login(email, password);
                session.setAttribute("utilisateur", user);
                if (user.getEmail().equals("admin")) {
                    return admin(model);
                }
                return "page/profil";
            } catch (Exception e) {
                e.printStackTrace();
                return "page/index";
            }
        }
        return "page/index";
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
    public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model, HttpSession session) throws Exception {
        if (result.hasErrors()) {
            return "/fileUploadPage";
        } else {
            MultipartFile multipartFile = file.getFile();
            String        path          = context.getRealPath("resources\\media") + File.separator;
            File          newfile       = new File(path + file.getFile().getOriginalFilename());
            FileCopyUtils.copy(file.getFile().getBytes(), newfile);
            String      fileName    = multipartFile.getOriginalFilename();
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
            Mp3Info     mp3Info     = new Mp3Info().extractMP3(newfile.getPath(), utilisateur.getId());
            model.addAttribute("fileName", fileName);
            model.addAttribute("infoMp3", mp3Info);

            return "page/profil";
        }
    }

    @RequestMapping(value = "/saveInfoMp3", method = RequestMethod.POST)
    public String saveInfoMp3(String path, HttpSession session, ModelMap model) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        service.saveFileUpload(path, utilisateur.getId());
        return home(model);
    }

    @RequestMapping(value = "telecharger/{idmp3}", method = RequestMethod.GET)
    public void getFile(@PathVariable("idmp3") String idmp3, HttpServletResponse response) throws IOException {
        InputStream in = null;
        try {
            Mp3Info mp3Info = service.getMp3ById(idmp3);
            File    file    = new File(mp3Info.getPath());
            in = new FileInputStream(file);
            response.setContentType("audio/mpeg");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            org.apache.commons.io.IOUtils.copy(in, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().print("Erreur telechargement");
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @RequestMapping(value = "favoris/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String saveFavoris(@PathVariable("id") String id, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        int         etat        = 0;
        if (utilisateur != null) {
            etat = 1;
            service.savefavoris(id, utilisateur.getId(), etat);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "playlist/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String ajoutplaylist(@PathVariable("id") String id, HttpSession session, ModelMap map) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        Mp3Info[]   songs       = service.getSongsId(id);
        String      titre       = songs[0].getTitre();
        if (utilisateur != null) {
            service.savePlaylist(id, utilisateur.getId(), titre);
            return home(map);
        }
        return "veuillez connecter!!!";
    }


    @RequestMapping(value = "/pagination/{page}/{nb}", method = RequestMethod.GET)
    public String pagination(@PathVariable int page, @PathVariable int nb, ModelMap model) throws Exception {
        if (page == 1) {
        } else {
            page = page - 1;
        }
        Mp3Info[] paginations = service.getPagination(nb, page);
        model.addAttribute("paginations", paginations);
        return home(model);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String menu(ModelMap model) throws Exception {
     Menu[] menu = service.getMenu();
        model.addAttribute("menus",menu);
        return "page/home";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String recherche (ModelMap model) throws Exception {
    Recherche[] recherche = service.getMp3Info();
        return "page/home";
    }
        

    @RequestMapping(value = "/media", method = RequestMethod.POST)
    public String removeBd (@RequestParam("chanson") long IdChanson) {
    Chanson chanson = service.connection_delete(IdChanson);
    service.connection_delete(chanson);
    return "redirect:/home";
    }
}

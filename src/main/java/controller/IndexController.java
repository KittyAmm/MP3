package controller;

import dao.BaseModele;
import modele.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@SessionAttributes("utilisateur")
@RequestMapping("/")
public class IndexController {
    private final Service service = new Service();

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String home(ModelMap model) throws Exception {
        ArrayList<BaseModele> songs = service.getSongs();
        model.addAttribute("chansons", songs);
        model.addAttribute("title", "Bienvenue KBH's Music");
//        ModelAndView       map  = new ModelAndView("page/home");
//        map.addObject("meilleuralbum",albums);
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET, path = "/profil")
    public String profil(ModelMap model) throws Exception {
//        ArrayList<BaseModele> albums = service.getMeilleurAlbum();
//        model.addAttribute("title", "Profil");
//        ModelAndView map = new ModelAndView("page/profil");
        // map.addObject("meilleuralbum",albums);
        return "page/profil";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String admin(ModelMap model) throws Exception {
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
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        ModelAndView index = new ModelAndView("index");
        if (email != null && !email.equals("") && password != null && !password.equals("")) {
            try {
                Utilisateur user = Service.login(email, password);
                ModelAndView map = new ModelAndView("page/profil");
                 map.addObject("utilisateur",user);
//                request.getSession().setAttribute("utilisateur",user);
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return index;
        }
        return index;
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

package controller;

import modele.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController {
    private final Service service = new Service();

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String home(ModelMap model) throws Exception {
        ArrayList<Album> albums = new ArrayList<>();
        Album            album  = new Album();
        album.setNom("Album Minou");
        albums.add(album);
        model.addAttribute("albums", albums);
        model.addAttribute("title", "Bienvenue KBH's Music");
        return "index";
    }


//    @RequestMapping(value = "favoris", method = RequestMethod.GET, path = "/index")
//    public String favoris(ModelMap model) throws Exception {
//        Album album = new Album();
//        album.setNom("paz");
//        model.addAttribute("album", album);
//        return "index";
//    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && !email.equals("") && password != null && !password.equals("")) {
            try {
                service.login(email, password);
                return "page/historique";
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return "index";
        }
        return "index";
    }
}

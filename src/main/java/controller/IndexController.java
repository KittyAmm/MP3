package controller;

import modele.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Fonction;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController {
    private Fonction fonction = new Fonction();

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


    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login(ModelMap model) throws Exception {
        Album album = new Album();
        album.setNom("paz");
        model.addAttribute("album", album);
        return "page/test";
    }
}

package controller;

import modele.*;
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

@Controller
@SessionAttributes("utilisateur")
@RequestMapping("/")
public class IndexController {
    private final Service service = new Service();
    @Autowired
    ServletContext context;

    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        return "page/bienvenue";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap map) {
        return "page/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/homei")
    public String homei(ModelMap model) {
//        Menu[] menu = service.getMenu();
//        model.addAttribute("menus", menu);
        return "page/profil";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String home(ModelMap model) throws Exception {
        return pagination(1, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profil")
    public String profil(ModelMap model, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            model.addAttribute("title", "Profil");
            double     upload    = service.getCountUpload(utilisateur.getId());
            double     telecharg = service.getCountTelechargement(utilisateur.getId());
            double     favori    = service.getCountFavoris(utilisateur.getId());
            double     playlist  = service.getCountPlaylist(utilisateur.getId());
            Mp3Info[]  songs     = service.getSongs();
            Playlist[] playlists = service.getPlaylist();
            if (playlists != null) {
                model.addAttribute("playlists", playlists);
            }
            model.addAttribute("favori", favori);
            model.addAttribute("upload", upload);
            model.addAttribute("telecharg", telecharg);
            model.addAttribute("playlist", playlist);
            model.addAttribute("chansons", songs);
            return "page/profil";
        }
        return "page/login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin")
    public String admin(ModelMap model, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            Mp3Info[] songs     = service.getSongs();
            double    upload    = service.getCountUpload();
            double    telecharg = service.getCountTelechargement();
            double    favori    = service.getCountFavoris();
            double    playlist  = service.getCountPlaylist();
            model.addAttribute("upload", upload);
            model.addAttribute("telecharg", telecharg);
            model.addAttribute("favori", favori);
            model.addAttribute("chansons", songs);
            return "page/admin";
        }
        return "page/login";
    }

    @RequestMapping(value = "uploadadmin", method = RequestMethod.POST)
    public String uploadAdmin(ModelMap model, @Validated FileModel file, BindingResult result, HttpSession session, String path) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            String    upload = fileUpload(file, result, model, session);
            Mp3Info[] songs  = service.getSongs();
            model.addAttribute("chansons", songs);
            return admin(model, session);
        }
        return "page/login";
    }

    @RequestMapping(value = "/saveInfoadmin", method = RequestMethod.POST)
    public String saveinfoadmin(String path, HttpSession session, ModelMap model) throws Exception {
        saveInfoMp3(path, session, model);
        return admin(model, session);
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
                    return admin(model, session);
                }
                return profil(model, session);
            } catch (Exception e) {
                e.printStackTrace();
                return "page/login";
            }
        }
        return "page/login";
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
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
            if (utilisateur != null) {
                MultipartFile multipartFile = file.getFile();
                String        path          = context.getRealPath("resources\\media") + File.separator;
                File          newfile       = new File(path + file.getFile().getOriginalFilename());
                FileCopyUtils.copy(file.getFile().getBytes(), newfile);
                String    fileName = multipartFile.getOriginalFilename();
                Mp3Info   mp3Info  = new Mp3Info().extractMP3(newfile.getPath(), utilisateur.getId());
                Mp3Info[] songs    = service.getSongs();
                model.addAttribute("fileName", fileName);
                model.addAttribute("infoMp3", mp3Info);
                model.addAttribute("chansons", songs);
                return profil(model, session);
            }

            return "page/login";
        }
    }

    @RequestMapping(value = "/saveInfoMp3", method = RequestMethod.POST)
    public String saveInfoMp3(String path, HttpSession session, ModelMap model) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        service.saveFileUpload(path, utilisateur.getId());
        return home(model);
    }

    @RequestMapping(value = "telecharger/{idmp3}/{titre}", method = RequestMethod.GET)
    public String getFile(@PathVariable("idmp3") String idmp3, @PathVariable("titre") String titre, ModelMap model, HttpServletResponse response, HttpSession session) throws IOException {
        InputStream in = null;
        try {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
            if (utilisateur != null) {
                Mp3Info mp3Info = service.getMp3ById(idmp3);
                File    file    = new File(mp3Info.getPath());
                in = new FileInputStream(file);
                response.setContentType("audio/mpeg");
                response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                response.setHeader("Content-Length", String.valueOf(file.length()));
                org.apache.commons.io.IOUtils.copy(in, response.getOutputStream());
                response.flushBuffer();
                service.saveTelecharger(idmp3, utilisateur.getId(), titre);
                return profil(model, session);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().print("Erreur telechargement");
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return login(model);
    }

    @RequestMapping(value = "favoris/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String saveFavoris(@PathVariable("id") String id, HttpSession session) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            int etat = 1;
            service.savefavoris(id, utilisateur.getId(), etat);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "synchrone", method = RequestMethod.GET)
    public String synchrone(HttpSession session, ModelMap model) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            service.synchrone();
            return admin(model, session);
        }
        return login(model);
    }

    @RequestMapping(value = "playlist/{id}/{titre}", method = RequestMethod.GET)
    public String ajoutplaylist(@PathVariable("id") String id, @PathVariable("titre") String titre, HttpSession session, ModelMap model) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            service.savePlaylist(id, utilisateur.getId(), titre);
            model.addAttribute("title", "Profil");
            double     upload    = service.getCountUpload(utilisateur.getId());
            double     telecharg = service.getCountTelechargement(utilisateur.getId());
            double     favori    = service.getCountFavoris(utilisateur.getId());
            double     playlist  = service.getCountPlaylist(utilisateur.getId());
            Mp3Info[]  songs     = service.getSongs();
            Playlist[] playlists = service.getPlaylist();
            if (playlists != null) {
                model.addAttribute("playlists", playlists);
            }
            model.addAttribute("favori", favori);
            model.addAttribute("upload", upload);
            model.addAttribute("telecharg", telecharg);
            model.addAttribute("playlist", playlist);
            model.addAttribute("chansons", songs);
            return profil(model, session);
        }
        return "page/login";
    }

    @RequestMapping(value = "supprimer/{id}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("id") String id, HttpSession session, ModelMap map) throws Exception {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            Mp3Info        info     = service.getMp3ById(id);
            Telechargement tel      = service.getTelechargId(id);
            Favoris        fav      = service.getFav(id);
            Playlist       playlist = service.getPlaylistId(id);
            service.deletePlaylist(playlist);
            service.deleteTelechargement(tel);
            service.deleteFavoris(fav);
            service.deletefile(info);

            return admin(map, session);
        }
        return "page/login";
    }


    @RequestMapping(value = "pagination/{page}", method = RequestMethod.GET)
    public String pagination(@PathVariable int page, ModelMap model) throws Exception {
        int nbaffiche = 3;
        int nbmp3info = service.getCountMp3();
        int nbpage    = nbmp3info / nbaffiche;
        if (nbmp3info % nbaffiche != 0) {
            nbpage = nbpage + 1;
        }
        Mp3Info[] nv          = service.nouveaute();
        Mp3Info[] paginations = service.getPagination(nbaffiche, page);
        model.addAttribute("nouveau", nv);
        model.addAttribute("nbpage", nbpage);
        model.addAttribute("paginations", paginations);
        model.addAttribute("title", "Bienvenue KBH's Music");
        return "page/index";
    }

    @RequestMapping(value = "/album")
    public String album(ModelMap map) throws Exception {
        Album[] albums = service.getAlbum();
        Genre[] genres = service.getGenre();
        map.addAttribute("albums", albums);
        map.addAttribute("genres", genres);
        return "page/album";
    }

    @RequestMapping(value = "/chanson")
    public String chanson(ModelMap map) throws Exception {
        Mp3Info[] ch = service.getSongs();
        map.addAttribute("ch", ch);
        return "page/chanson";
    }

    @RequestMapping(value = "/artiste")
    public String artiste(ModelMap map) {
//        Album[] albums = service.getAlbum();
//        map.addAttribute("albums", albums);
        return "page/artiste";
    }

    @RequestMapping(value = "/searchadvanced", method = RequestMethod.GET)
    public String searchadvanced(ModelMap model, HttpServletRequest request) {
        String titre   = request.getParameter("titre");
        String artiste = request.getParameter("artiste");
        if (titre != null && !titre.equals("") || artiste != null && !artiste.equals("")) {
            try {
                Mp3Info[] val = service.rechercheMulti(titre, artiste);
                model.addAttribute("val", val);
                return "page/searchadvanced";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "page/searchadvanced";
    }
}

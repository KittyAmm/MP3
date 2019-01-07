package service;

import modele.Mp3Info;
import modele.Utilisateur;

public class Service {
    private static Fonction fonction = new Fonction();

    public static Utilisateur login(String user, String pass) throws Exception {
        if (user.equals("")) {

            throw new Exception("Votre adresse email est vide");
        }
        return fonction.login(user, pass);
    }

    //top
    //playlist
    //nouveauté
    //songs
    public Mp3Info[] getSongs() throws Exception {
        return fonction.getSongs();
    }

    public void saveFileUpload(String path, String user) throws Exception {
        System.out.println(path);
        fonction.saveFile(path, user);
    }

    public void savefavoris(String idmp3info, String iduser) throws Exception {
        fonction.ajoutfavoris(idmp3info,iduser);
    }

    public Mp3Info getMp3ById(String id) throws Exception {
        return fonction.getMp3ById(id);
    }
}

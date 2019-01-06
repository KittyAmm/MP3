package service;

import modele.Chanson;
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
    public Chanson[] getSongs() throws Exception {
        return fonction.getSongs();
    }

    public void saveFileUpload(String path, Utilisateur user) throws Exception {
        System.out.println(path);
        fonction.saveFile(path, user);
    }

}

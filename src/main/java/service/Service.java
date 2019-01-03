package service;

import modele.Utilisateur;

public class Service {
    private static Fonction fonction = new Fonction();
    public static Utilisateur login(String user, String pass) throws Exception {
        if (user == null || user.equals("")) {
            throw new Exception("Votre adresse email est vide");
        }
        return fonction.login(user, pass);
    }

    //top
    //playlist
    //nouveauté
    //meilleur album
//    public ArrayList<BaseModele> getMeilleurAlbum() throws Exception {
//        return fonction.getMeilleurAlbum();
//    }
    //meilleur artiste
    //songs

}

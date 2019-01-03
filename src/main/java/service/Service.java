package service;

import dao.BaseModele;
import modele.Utilisateur;

import java.util.ArrayList;

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
    //meilleur album
//    public ArrayList<BaseModele> getMeilleurAlbum() throws Exception {
//        return fonction.getMeilleurAlbum();
//    }
    //meilleur artiste
    //songs
    public ArrayList<BaseModele> getSongs() throws Exception {
        return fonction.getSongs();
    }

}

package service;

import modele.Mp3Info;
import modele.Playlist;
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
    public void savePlaylist(String idmp3info, String iduser) throws Exception {
        fonction.ajoutPlaylist(idmp3info,iduser);
    }

    public Playlist[] getPlaylist() throws Exception {
        return fonction.Playlist();
    }
    //nouveauté
    //songs
    public Mp3Info[] getSongs() throws Exception {
        return fonction.getSongs();
    }

    public void saveFileUpload(String path, String user) throws Exception {
        System.out.println(path);
        fonction.saveFile(path, user);
    }

    public void savefavoris(String idmp3info, String iduser,int etat) throws Exception {
        fonction.ajoutfavoris(idmp3info,iduser,etat);
    }

    public Mp3Info getMp3ById(String id) throws Exception {
        return fonction.getMp3ById(id);
    }

    public Mp3Info[] getPagination(int nb,int index) throws Exception {
        return fonction.getPagination(nb,index);
    }
}

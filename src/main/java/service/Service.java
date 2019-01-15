package service;

import modele.*;

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
    public void savePlaylist(String idmp3info, String iduser, String titre) throws Exception {
        fonction.ajoutPlaylist(idmp3info, iduser, titre);
    }

    public Playlist[] getPlaylist() throws Exception {
        return fonction.Playlist();
    }

    public Menu[] getMenu() throws Exception {
        return fonction.getMenu();
    }

    public Albums[] getAlbum() throws Exception {
        return fonction.getAlbums();
    }

    //nouveauté
    //songs
    public Mp3Info[] getSongs() throws Exception {
        return fonction.getSongs();
    }

    public Mp3Info[] getSongsId(String id) throws Exception {
        return fonction.getSongsbyId(id);
    }

    public int getCountFavoris() throws Exception {
        return fonction.count(new Favoris());
    }

    public double getCountUpload() throws Exception {
        return fonction.count(new Mp3Info());
    }

    public double getCountTelechargement() throws Exception {
        return fonction.count(new Telechargement());
    }

    public double getCountPlaylist() throws Exception {
        return fonction.count(new Playlist());
    }

    public int getCountFavoris(String iduser) throws Exception {
        return fonction.count(new Favoris(), iduser);
    }

    public double getCountUpload(String iduser) throws Exception {
        return fonction.count(new Mp3Info(), iduser);
    }

    public int getCountMp3() throws Exception {
        return fonction.count(new Mp3Info());
    }

    public double getCountTelechargement(String iduser) throws Exception {
        return fonction.count(new Telechargement(), iduser);
    }

    public double getCountPlaylist(String iduser) throws Exception {
        return fonction.count(new Playlist(), iduser);
    }


    public void saveFileUpload(String path, String user) throws Exception {
        System.out.println(path);
        fonction.saveFile(path, user);
    }

    public void savefavoris(String idmp3info, String iduser, int etat) throws Exception {
        fonction.ajoutfavoris(idmp3info, iduser, etat);
    }

    public void saveTelecharger(String idmp3info, String iduser, String titre) throws Exception {
        fonction.telechargement(idmp3info, iduser, titre);
    }

    public void supprimer(String path, String iduser) throws Exception {
        Mp3Info[] songs = getSongs();
//        fonction.DeleteRepertoire(path, iduser, );
    }

    public Mp3Info getMp3ById(String id) throws Exception {
        return fonction.getMp3ById(id);
    }

    public Mp3Info[] getPagination(int nb, int index) throws Exception {
        return fonction.getPagination(nb, index);
    }
    public Chanson[] getChanson() throws Exception {
        return fonction.getChanson();
    }



}

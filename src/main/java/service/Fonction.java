package service;

import dao.BaseModele;
import dao.GenericDao;
import dao.HibernateDao;
import dao.connex.Connexion;
import modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Fonction {
    @Autowired
    private GenericDao   dao  = new GenericDao();
    private HibernateDao hdao = new HibernateDao();

    public void saveFile(String path, String user) throws Exception {
        Mp3Info    info = new Mp3Info().extractMP3(path, user);
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            String duree = info.getDuree();
            dao.save(info, conn);
//            Chanson chanson = new Chanson(info.getTitre(), Integer.parseInt(duree), info.getPublish(), info.getImage(), user.getId());
//            dao.save(chanson, conn);
//            Artiste artistE = new Artiste(info.getImage(), chanson.getId(), info.getArtiste());
//            dao.save(artistE, conn);
//            Album albuM = new Album(info.getAlbum());
//            dao.save(albuM, conn);
//            Genre genrE = new Genre(info.getImage(), chanson.getId(), info.getGenre());
//            dao.save(genrE, conn);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }

    }

    public Utilisateur login(String email, String pass) throws Exception {
        try {
            String           where   = String.format("mail='%s' and mdp='%s'", email, pass);
            List<BaseModele> clients = dao.findAll(new Utilisateur(), where);
            if (clients.size() != 0)
                return (Utilisateur) clients.get(0);
            else {
                throw new Exception("Adresse email ou mot de passe invalid");
            }
        } catch (Exception e) {
            throw new Exception("Erreur :" + e.getMessage());
        }
    }

    public void inscrire(String username, String password, String email, String birth, String sexe) throws Exception {
        try {
            Utilisateur client = new Utilisateur(username, password, email, birth, sexe);
            dao.save(client);
        } catch (Exception e) {
            throw new Exception("Erreur: " + e.getMessage());
        }
    }

    public Mp3Info[] getSongs() throws Exception {
        ArrayList<BaseModele> chansons = dao.findAll(new Mp3Info());
        return chansons.toArray(new Mp3Info[chansons.size()]);
    }

    //Telecharger
    public Mp3Info getMp3ById(String id) throws Exception {
        Mp3Info mp3Info = new Mp3Info();
        dao.findById(mp3Info, id);
        return mp3Info;
    }

    //favoris
    public void ajoutfavoris(String idmp3info, String iduser, int etat) throws Exception {
        Date       date       = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String     strDate    = dateFormat.format(date);
        System.out.println("converted Date to String: " + strDate);
        try {
            Favoris favoris = new Favoris();
            favoris.setIdmp3info(idmp3info);
            favoris.setIduser(iduser);
            favoris.setDatefav(strDate);
            favoris.setEtat(etat);
            hdao.save(favoris);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //nbtelechargement
    public Telechargement[] countTelechargement(BaseModele bm, String user) throws Exception {
        String req = "select count(id) as nb from %s where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, bm);
        return telecharg.toArray(new Telechargement[telecharg.size()]);
    }
    //nbfavoris

    public Favoris[] countFavoris(BaseModele bm, String user) throws Exception {
        String req = "select count(id) as nb from %s where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, bm);
        return telecharg.toArray(new Favoris[telecharg.size()]);
    }

    public Favoris[] countTitreFavoris(BaseModele bm, String user) throws Exception {
        String req = "select count(titre) as nb from %s where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, bm);
        return telecharg.toArray(new Favoris[telecharg.size()]);
    }

    //nb playlist
    public Playlist[] countPlayList(BaseModele bm, String user) throws Exception {
        String req = "select count(id) as nb from %s where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, bm);
        return telecharg.toArray(new Playlist[telecharg.size()]);
    }
    //nb upload

    public Mp3Info[] countUpload(BaseModele bm, String user) throws Exception {
        String req = "select count(id) as nb from %s where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, bm);
        return telecharg.toArray(new Mp3Info[telecharg.size()]);
    }

    public Mp3Info[] getPagination(int nb, int index) throws Exception {
        ArrayList<BaseModele> pag = dao.findAll(new Mp3Info(), nb, index);
        return pag.toArray(new Mp3Info[pag.size()]);
    }

    public void ajoutPlaylist(String idsong,String user) throws Exception {
        Playlist c = new Playlist();
        try {
            c.setId(idsong);
            c.setIdclient(user);
            dao.save(c);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Playlist[] Playlist() throws Exception {
        try {
            ArrayList<BaseModele> playlist = dao.findAll(new Mp3Info());
            return playlist.toArray(new Playlist[playlist.size()]);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

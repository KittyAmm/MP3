package service;

import dao.BaseModele;
import dao.GenericDao;
import dao.HibernateDao;
import dao.connex.Connexion;
import modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
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
            String     duree      = info.getDuree();
            Date       date       = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            String     strDate    = dateFormat.format(date);
            dao.save(info, conn);
            System.out.println(info.getTitre());
            Genre genrE = new Genre(info.getGenre(), strDate);
            dao.save(genrE, conn);
            System.out.println(genrE.getNom());
            Artiste artistE = new Artiste(info.getArtiste(), strDate);
            dao.save(artistE, conn);
            Albums Albums = new Albums(artistE.getId(), info.getAlbum(), strDate, info.getPublish());
            dao.save(Albums, conn);
            Chanson chanson = new Chanson(artistE.getId(), genrE.getId(), duree, strDate, Albums.getId(), info.getTitre(), info.getPublish());
            dao.save(chanson, conn);
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

    public Mp3Info[] getSongsbyId(String id) throws Exception {
        ArrayList<BaseModele> chansons = dao.findAll(new Mp3Info(), "id =" + id);
        return chansons.toArray(new Mp3Info[chansons.size()]);
    }

    public Mp3Info[] getSongs() throws Exception {
        ArrayList<BaseModele> chansons = dao.findAll(new Mp3Info());
        return chansons.toArray(new Mp3Info[chansons.size()]);
    }

    public Albums[] getAlbums() throws Exception {
        ArrayList<BaseModele> Albumss = dao.findAll(new Albums());
        return Albumss.toArray(new Albums[Albumss.size()]);
    }

    public Menu[] getMenu() throws Exception {
        ArrayList<BaseModele> menu = dao.findAll(new Menu());
        return menu.toArray(new Menu[menu.size()]);
    }

    public Chanson[] getChanson() throws Exception {
        ArrayList<BaseModele> chansons = dao.findAll(new Chanson());
        return chansons.toArray(new Chanson[chansons.size()]);
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
        String req   = "select count(id) as nb from %s";
        String where = "where iduser ='" + user + "'";
        System.out.println(req);
        ArrayList<BaseModele> telecharg = dao.findQuery(req, where, bm);
        return telecharg.toArray(new Telechargement[telecharg.size()]);
    }
    //nbfavoris

    public int count(BaseModele bm, String user) throws Exception {
        return dao.GetCount(bm, "iduser ='" + user + "'");
    }

    public int count(BaseModele bm) throws Exception {
        return dao.GetCount(bm, "");
    }

    public int countTitreFavoris(BaseModele bm, String user) throws Exception {
        String where = "iduser ='" + user + "'";
        return dao.GetCount(bm, where);
    }

    //nb playlist

    //nb upload

    public Mp3Info[] getPagination(int nb, int index) throws Exception {
        ArrayList<BaseModele> pag = dao.findAll(new Mp3Info(), nb, index);
        return pag.toArray(new Mp3Info[pag.size()]);
    }

    public void ajoutPlaylist(String idsong, String user, String titre) throws Exception {
        Date       date       = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String     strDate    = dateFormat.format(date);
        try {
            Playlist c = new Playlist(idsong, user, strDate, titre);
            dao.save(c);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void telechargement(String idmp3info, String user, String titre) throws Exception {
        Date       date       = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String     strDate    = dateFormat.format(date);
        try {
            Telechargement c = new Telechargement(user, strDate,idmp3info, titre);
            dao.save(c);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Playlist[] Playlist() throws Exception {
        try {
            ArrayList<BaseModele> playlist = dao.findAll(new Playlist());
            return playlist.toArray(new Playlist[playlist.size()]);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void DeleteRepertoire(String iduser, Mp3Info m) throws Exception {
        try {

            File file = new File(m.url(),iduser);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            }
//            if () {
//                dao.delete(m,iduser);
//            }
            else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Mp3Info[] Top5() throws Exception {
        String                requete  = "select*from Mp3Info LIMIT 5";
        ArrayList<BaseModele> chansons = dao.findAll(new Mp3Info(), requete);
        return chansons.toArray(new Mp3Info[chansons.size()]);
    }

}

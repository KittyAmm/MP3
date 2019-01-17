package service;

import com.mpatric.mp3agic.BaseException;
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

    public void saveFile(String path, String user) throws Exception {
        Mp3Info    info = new Mp3Info().extractMP3(path, user);
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            dao.save(info, conn);
            Genre genrE = new Genre(info.getGenre(), info.getDateajout());
            dao.save(genrE, conn);
            Artiste artistE = new Artiste(info.getArtiste(), info.getDateajout());
            dao.save(artistE, conn);
            Album album = new Album(artistE.getId(), info.getAlbum(), info.getDateajout(), info.getPublish());
            dao.save(album, conn);
            Chanson chanson = new Chanson(artistE.getId(), genrE.getId(), info.getDuree(), info.getDateajout(), album.getId(), info.getTitre(), info.getPublish());
            dao.save(chanson, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw new Exception(e.getMessage());
        } finally {
            Connexion.fermerRessource(conn, null, null);
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

    public Album[] getAlbums() throws Exception {
        ArrayList<BaseModele> Albumss = dao.findAll(new Album());
        return Albumss.toArray(new Album[Albumss.size()]);
    }

    public Genre[] getGenre() throws Exception {
        ArrayList<BaseModele> genres = dao.findAll(new Genre());
        return genres.toArray(new Genre[genres.size()]);
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

    public Playlist getPlaylistId(String id) throws Exception {
        Playlist mp3Info = new Playlist();
        dao.findByColonne(mp3Info, "idson", id);
        return mp3Info;
    }

    public Favoris getFav(String id) throws Exception {
        Favoris mp3Info = new Favoris();
        dao.findByColonne(mp3Info, "idmp3info ", id);
        return mp3Info;
    }

    public Mp3Info[] getMp3InfoByPath(String path) throws Exception {
        ArrayList<BaseModele> bm = dao.findAll(new Mp3Info(), "path =" + "'" + path + "'");
        return bm.toArray(new Mp3Info[bm.size()]);
    }

    //favoris
    public void ajoutfavoris(String idmp3info, String iduser, int etat) throws Exception {
        Date       date       = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String     strDate    = dateFormat.format(date);
        try {
            Telechargement c = new Telechargement(user, strDate, idmp3info, titre);
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

    public Mp3Info[] Top5() throws Exception {
        String                requete  = "select*from Mp3Info LIMIT 5";
        ArrayList<BaseModele> chansons = dao.findAll(new Mp3Info(), requete);
        return chansons.toArray(new Mp3Info[chansons.size()]);
    }

    public Mp3Info[] nouveaute() throws Exception {
        Date                  date       = new Date();
        DateFormat            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String                strDate    = dateFormat.format(date);
        String                where      = "datedajout <= " + "'" + strDate + "'" + " limit 3";
        ArrayList<BaseModele> playlist   = dao.findAll(new Mp3Info(), where);
        return playlist.toArray(new Mp3Info[playlist.size()]);
    }


    public Album getAlbumById(String id) throws Exception {
        Album album = new Album();
        dao.findById(album, "id =' " + id + "'");
        return album;
    }

    public Artiste getArtisteById(String id) throws Exception {
        Artiste art = new Artiste();
        dao.findById(art, "id =' " + id + "'");
        return art;
    }

    public Genre getGenreById(String id) throws Exception {
        Genre genre = new Genre();
        dao.findById(genre, "id =" + "'" + id + "'");
        return genre;
    }

    public Chanson getChansonById(String id) throws Exception {
        Chanson art = new Chanson();
        dao.findById(art, "id =" + "'" + id + "'");
        return art;
    }

    private boolean fichierExist(String path) {
        File f = new File(path);
        System.out.println(f.getName());
        return f.exists();
    }

    private boolean filebddExist(String path) throws Exception {
        Mp3Info[] infos = getMp3InfoByPath(path);
        return true;
    }


    public void deletefichier(Mp3Info path) throws Exception {
        try {
            if (!fichierExist(path.getPath()))
                throw new BaseException("Destination directory \"" + path.getPath() + "\" cannot be found");
            File file = new File(path.getPath());
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");
            }
        } catch (BaseException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deletePlaylist(Playlist playlist) throws Exception {
        Connection c = null;
        try {
            c = Connexion.getConnexion();
            dao.delete(playlist, c);
            System.out.println("playlist delete");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (c != null) {
                Connexion.fermerRessource(c, null, null);
            }
        }
    }

    public void deletetelecharg(Telechargement tel) throws Exception {
        Connection c = null;
        try {
            c = Connexion.getConnexion();
            dao.delete(tel, c);
            System.out.println("delete telecharg");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (c != null) {
                Connexion.fermerRessource(c, null, null);
            }
        }
    }


    public void deleteFileBdd(Mp3Info info) throws Exception {
        Connection c = null;
        try {
            c = Connexion.getConnexion();
            dao.delete(info, c);
            System.out.println("delete mp3info");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (c != null) {
                Connexion.fermerRessource(c, null, null);
            }
        }
    }


    public void deletetefavoris(Favoris fav) throws Exception {
        Connection c = null;
        try {
            c = Connexion.getConnexion();
            dao.delete(fav, c);
            System.out.println("favoris delete");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (c != null) {
                Connexion.fermerRessource(c, null, null);
            }
        }
    }

    public Telechargement getTelechargId(String id) throws Exception {
        Telechargement mp3Info = new Telechargement();
        dao.findByColonne(mp3Info, "idimp3info ", id);
        return mp3Info;
    }

    public String[] parcourirFile() {
        File dir = new File(Util.PATH);
        return dir.list();
    }

    private void deleteNotFound(Mp3Info[] mp3Infos, String[] files, Connection conn) throws Exception {
        for (Mp3Info info : mp3Infos) {
            boolean trouver = false;
            for (String file : files) {
                if (info.getPath().equals(file)) {
                    trouver = true;
                    break;
                }
            }
            if (!trouver) {
                Telechargement tel      = getTelechargId(info.getId());
                Favoris        fav      = getFav(info.getId());
                Playlist       playlist = getPlaylistId(info.getId());
                dao.delete(playlist, conn);
                dao.delete(fav, conn);
                dao.delete(tel, conn);
                dao.delete(info, conn);
            }
        }
    }

    private void saveNotFound(Mp3Info[] infos, String[] files, Connection conn) throws Exception {
        for (String file : files) {
            boolean trouver = false;
            for (Mp3Info info : infos) {
                if (file.equals(info.filename())) {
                    trouver = true;
                    break;
                }
            }
            if (!trouver) {
                String path = Util.PATH + File.separator + file;
                System.out.println(path);
                Mp3Info info = new Mp3Info().extractMP3(path, "UTI1");
                System.out.println(info.getTitre());
                dao.save(info, conn);
            }
        }
    }

    public void synchronisation() throws Exception {
        Connection c        = null;
        Mp3Info[]  mp3Infos = getSongs();
        String[]   files    = parcourirFile();
        try {
            c = Connexion.getConnexion();
            deleteNotFound(mp3Infos, files, c);
            saveNotFound(mp3Infos, files, c);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            if (c != null) {
                Connexion.fermerRessource(c, null, null);
            }
        }
    }

    public void deleteRehetra(Mp3Info path) throws Exception {
        deleteFileBdd(path);
        deletefichier(path);
    }


    public Mp3Info[] FindMulti(String titre, String artiste) throws Exception {
        try {
            String                where = "titre LIKE '%s' or artiste LIKE '%s'";
            ArrayList<BaseModele> reach = dao.findAll(new Mp3Info(), String.format(where, titre, artiste));
            System.out.println(reach.size());
            return reach.toArray(new Mp3Info[reach.size()]);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

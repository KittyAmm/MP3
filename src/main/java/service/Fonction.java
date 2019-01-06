package service;

import dao.BaseModele;
import dao.GenericDao;
import dao.connex.Connexion;
import modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Component
public class Fonction {
    @Autowired
    private GenericDao dao = new GenericDao();

    public void saveFile(String path, Utilisateur user) throws Exception {
        Mp3Info    info = new Mp3Info().extractMP3(path);
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
            String           where   = String.format("email='%s' and password='%s'", email, pass);
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

    public Chanson[] getSongs() throws Exception {
        ArrayList<BaseModele> chansons = dao.findAll(new Chanson());
        return chansons.toArray(new Chanson[chansons.size()]);
    }

    //Telecharger
    //Extract info
    //favoris
}

package service;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import dao.BaseModele;
import dao.GenericDao;
import modele.Chanson;
import modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Fonction {
    @Autowired
    private GenericDao dao = new GenericDao();

    public Utilisateur login(String email, String pass) throws Exception {
        try {
            String where = String.format("email='%s' and password='%s'", email, pass);
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

    public ArrayList<BaseModele> getSongs() throws Exception {
        return dao.findAll(new Chanson());
    }

    public void extractMP3(String filename) throws InvalidDataException, IOException, UnsupportedTagException {
        Mp3File mp3File = new Mp3File(filename);
        if (mp3File.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3File.getId3v2Tag();
//            byte[] imageData = id3v2tag.getAlbumImage();
            String titre    = id3v2tag.getTitle();
            String album    = id3v2tag.getAlbumArtist();
            String artist   = id3v2tag.getArtist();
            int    genre    = id3v2tag.getGenre();
            int    data     = id3v2tag.getDataLength();
            String original = id3v2tag.getOriginalArtist();
            String publish  = id3v2tag.getPublisher();
            String comment  = id3v2tag.getComment();
            String dec      = id3v2tag.getGenreDescription();
            String version  = id3v2tag.getVersion();
            int    taille   = id3v2tag.getLength();
            //converting the bytes to an image
//            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
            System.out.println("titre: " + titre);
        }
    }

    public String readArtist(String path) throws InvalidDataException, IOException, UnsupportedTagException {
        Mp3File mp3File  = new Mp3File(path);
        ID3v2   id3v2Tag = mp3File.getId3v2Tag();
        return id3v2Tag.getArtist();
    }

//    public ArrayList<BaseModele> getMeilleurAlbum() throws Exception {
//        return dao.findAll(new Album(), "");
//    }
//
//    public ArrayList<BaseModele> getMeilleurArtistes() throws Exception {
//        return dao.findAll(new Artiste(), "");
//    }


    //Telecharger
    //Extract info
    //favoris
}

package modele;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import dao.BaseModele;

import javax.persistence.Entity;
import java.io.IOException;

@Entity
public class Mp3Info extends BaseModele {
    private String path;
    private String track;
    private String artiste;
    private String titre;
    private String album;
    private String annee;
    private String genre;
    private String comment;
    private int    data;
    private String publish;
    private String description;
    private String version;
    private int    taille;
    private String image;
    private String duree;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Mp3Info() {
    }

    public Mp3Info extractMP3(String path) throws InvalidDataException, IOException, UnsupportedTagException {
        this.path = path;
        Mp3File mp3File = new Mp3File(path);
        duree = String.valueOf(mp3File.getLengthInSeconds());
        if (mp3File.hasId3v2Tag()) {
            ID3v2 info = mp3File.getId3v2Tag();
            titre = info.getTitle();
            if (titre == null) {
                titre = mp3File.getFilename();
            }
            album = info.getAlbumArtist();
            artiste = info.getArtist();
            genre = String.valueOf(info.getGenre());
            data = info.getDataLength();
            publish = info.getPublisher();
            comment = info.getComment();
            description = info.getGenreDescription();
            version = info.getVersion();
            taille = info.getLength();
            image = info.getAlbumImageMimeType();
        }
        return this;
    }
}

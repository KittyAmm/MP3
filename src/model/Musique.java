package model;

import dao.BaseModele;

import java.sql.Time;

public class Musique extends BaseModele{
    private String titre;
    private String idartiste;
    private String idgenre;
    private Time duree;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIdartiste() {
        return idartiste;
    }

    public void setIdartiste(String idartiste) {
        this.idartiste = idartiste;
    }
    public String getIdgenre(){
        return idgenre;
    }
}

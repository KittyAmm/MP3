package model;

import dao.BaseModele;

public class Musique extends BaseModele{
    private String titre;
    private String idartiste;

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
}

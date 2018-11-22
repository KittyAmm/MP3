/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Haja Faniry
 */
public class Song extends BaseModele  {
    String idsong;
    String idartiste;
    String titre;
    String duree;
    String datesortie;

    public void setIdsong(String idsong) {
        this.idsong = idsong;
    }

    public void setIdartiste(String idartiste) {
        this.idartiste = idartiste;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setDatesortie(String datesortie) {
        this.datesortie = datesortie;
    }

    public String getIdsong() {
        return idsong;
    }

    public String getIdartiste() {
        return idartiste;
    }

    public String getTitre() {
        return titre;
    }

    public String getDuree() {
        return duree;
    }

    public String getDatesortie() {
        return datesortie;
    }
    
}

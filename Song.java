/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.BaseModele;
import dao.annotation.Column;
import dao.annotation.Table;
/**
 *
 * @author Haja Faniry
 */
@Table(name = "Song")
public class Song extends BaseModele {
    
    @Column(name = "idsong")
    private String idsong;
    
    @Column(name = "idartiste")
    private String idartiste;
    
    @Column(name = "titre")
    private String titre;
    
    @Column(name = "duree")
    private String duree;
    
    @Column(name = "datesortie")
    private String datesortie;

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

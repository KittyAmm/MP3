/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.BaseModele;
import dao.annotation.Column;
import dao.annotation.Table;

import javax.persistence.Entity;

/**
 * @author Haja Faniry
 */
@Entity
@Table(name = "Chanson")
public class Chanson extends BaseModele {

    @Column(name = "idartiste")
    @javax.persistence.Column(name = "idartiste")
    private String artiste;

    private String idgenre;

    @Column(name = "duree")
    @javax.persistence.Column(name = "duree")
    private String duree;

    @Column(name = "datedajout")
    @javax.persistence.Column(name = "datedajout")
    private String datesortie;

    @Column(name = "idalbum")
    @javax.persistence.Column(name = "idalbum")
    private String idalbum;

    @Column(name = "titre")
    @javax.persistence.Column(name = "titre")
    private String title;

    @Column(name = "datepublier")
    @javax.persistence.Column(name = "dapublier")
    private  String datepublier;

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(String datesortie) {
        this.datesortie = datesortie;
    }

    public String getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatepublier() {
        return datepublier;
    }

    public void setDatepublier(String datepublier) {
        this.datepublier = datepublier;
    }
}

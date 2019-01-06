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
 * @author Haja Faniry
 */

@Table(name = "Albums")
public class Album extends BaseModele {

    @Column(name = "idartiste")
    private String artiste;

    @Column(name = "idimage")
    private String idimage;

    @Column(name = "nom")
    private String nom;


    @Column(name = "datedajout")
    private String dateajout;


    @Column(name = "datepublier")
    private String datepub;

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getDateajout() {
        return dateajout;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    public String getDatepub() {
        return datepub;
    }

    public void setDatepub(String datepub) {
        this.datepub = datepub;
    }

    public Album() {
    }
    public void setIdimage(String idimage) {
        this.idimage = idimage;
    }

    public void setNom(String nom) throws Exception {
        if (nom.equals("")) {
            throw new Exception("nom album vide");
        }
        this.nom = nom;
    }

    public String getIdimage() {
        return idimage;
    }

    public String getNom() {
        return nom;
    }

    public Album(String nom) {
        this.nom = nom;
    }
}

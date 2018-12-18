/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.BaseModele;
import dao.annotation.NotColumn;
import dao.annotation.Table;
import dao.annotation.Column;

/**
 * @author Haja Faniry
 */
@Table(name = "Albums")
public class Album extends BaseModele {
    @Column(name = "idart")
    private String idartiste;

    @Column(name = "image")
    private String idimage;

    @Column(name = "nomalbum")
    private String nom;

    public Album() {
    }

    public void setIdartiste(String id) throws Exception {
        if (id.equals("")) {
            throw new Exception("id artiste vide");
        }
        idartiste = id;
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

    public String getIdartiste() {
        return idartiste;
    }

    public String getIdimage() {
        return idimage;
    }

    public String getNom() {
        return nom;
    }


}

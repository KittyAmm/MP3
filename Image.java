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
@Table(name = "Image")
public class Image extends BaseModele {
    
    @Column(name = "idimage")
    private String idimage;
    
    @Column(name = "nom")
    private String nom;

    public String getIdimage() {
        return idimage;
    }

    public String getNom() {
        return nom;
    }

    public void setIdimage(String idimage) {
        this.idimage = idimage;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}

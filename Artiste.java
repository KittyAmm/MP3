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
@Table(name = "Artiste")
public class Artiste extends BaseModele {

    @Column(name = "idartiste")
    private String idartiste;
    
    @Column(name = "idimage")
    private String idimage;
    
    @Column(name = "idsong")
    private String idsong;
    
    @Column(name = "nom")
    private String nom;

    public void setIdartiste(String idartiste) {
        this.idartiste = idartiste;
    }

    public void setIdimage(String idimage) {
        this.idimage = idimage;
    }

    public void setIdsong(String idsong) {
        this.idsong = idsong;
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

    public String getIdsong() {
        return idsong;
    }

    public String getNom() {
        return nom;
    }
    
    
    
}

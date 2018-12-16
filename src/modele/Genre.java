/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.BaseModele;

/**
 *
 * @author Haja Faniry
 */
public class Genre extends BaseModele {
    String idgenre;
    String idimage;
    String idsong;
    String nom;

    public String getIdgenre() {
        return idgenre;
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

    public void setIdgenre(String idgenre) {
        this.idgenre = idgenre;
    }

    public void setIdimage(String idimage) {
        this.idimage = idimage;
    }

    public void setIdsong(String idsong) {
        this.idsong = idsong;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}

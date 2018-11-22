/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelemp3master;

/**
 *
 * @author Haja Faniry
 */
public class Artiste extends BaseModele {

    String idartiste;
    String idimage;
    String idsong;
    String nom;

    public void setIdartiste(String idartiste) {
        this.idartiste = idartiste;
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

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
public class Album extends BaseModele  {
    
    String idalbum;
    String idartiste;
    String idimage;
    String nom;

    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    public void setIdartiste(String idartiste) {
        this.idartiste = idartiste;
    }

    public void setIdimage(String idimage) {
        this.idimage = idimage;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdalbum() {
        return idalbum;
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

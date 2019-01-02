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
@Table(name = "Albums")
public class Genre extends BaseModele {
    
    @Column(name = "idgenre")
    private String idgenre;
    
    @Column(name = "idimage")
    private String idimage;
    
    @Column(name = "idsong")
    private String idsong;
    
    @Column(name = "nom")
    private String nom;

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

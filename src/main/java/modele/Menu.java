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
@Table(name = "Menu")
public class Menu extends BaseModele {
    
    @Column(name = "idmenu")
    private String idmenu ;
    
     @Column(name = "nom")
    private String nom ;

    public Menu(String idmenu, String nom) {
        this.idmenu = idmenu;
        this.nom = nom;
    }

    public String getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(String idmenu) {
        this.idmenu = idmenu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    
}

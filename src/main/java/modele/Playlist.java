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
@Table(name = "Playlist")
public class Playlist extends BaseModele {
    
    @Column(name = "idp")
    private String idp;
    
    @Column(name = "idsong")
    private String idsong;
    
    @Column(name = "datejout")
    private String dateajout;

    public String getIdp() {
        return idp;
    }

    public String getIdsong() {
        return idsong;
    }

    public String getDateajout() {
        return dateajout;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public void setIdsong(String idsong) {
        this.idsong = idsong;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }
    
    
}

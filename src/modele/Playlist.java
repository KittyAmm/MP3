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
public class Playlist extends BaseModele  {
    
    String idp;
    String idsong;
    String dateajout;

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

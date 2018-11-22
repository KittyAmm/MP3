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
public class Utilisateur extends BaseModele {
 String iduser;
 String nomuser;
 String pswrd;
 String Email;
 String sexe;
 String datenaissance;

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getIduser() {
        return iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public String getPswrd() {
        return pswrd;
    }

    public String getEmail() {
        return Email;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDatenaissance() {
        return datenaissance;
    }
 
    
     
}

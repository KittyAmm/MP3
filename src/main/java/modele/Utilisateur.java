/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.BaseModele;
import dao.annotation.Column;
import dao.annotation.Table;

import javax.persistence.Entity;

/**
 * @author Haja Faniry
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends BaseModele {

    @Column(name = "nom")
    @javax.persistence.Column(name = "nom")
    private String nomuser;

    @Column(name = "mdp")
    @javax.persistence.Column(name = "mdp")
    private String pswrd;

    @Column(name = "mail")
    @javax.persistence.Column(name = "mail")
    private String email;

    @Column(name = "datenaissance")
    @javax.persistence.Column(name = "datenaissance")
    private String birth;

    @Column(name = "sexe")
    @javax.persistence.Column(name = "sexe")
    private String sexe;

    @Column(name = "datedajout")
    @javax.persistence.Column(name = "datedajout")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNomuser() {
        return nomuser;
    }

    public String getPswrd() {
        return pswrd;
    }

    public String getEmail() {
        return email;
    }

    public String getSexe() {
        return sexe;
    }

    public Utilisateur(String nomuser, String pswrd, String email, String birth, String sexe) {
        this.nomuser = nomuser;
        this.pswrd = pswrd;
        this.email = email;
        this.birth = birth;
        this.sexe = sexe;
    }

    public Utilisateur() {
    }
}

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
 * @author Haja Faniry
 */
@Table(name = "Utilisateur")
public class Utilisateur extends BaseModele {

    @Column(name = "username")
    private String nomuser;

    @Column(name = "password")
    private String pswrd;

    @Column(name = "email")
    private String Email;

    @Column(name = "birth")
    private String birth;

    @Column(name = "sexe")
    private String sexe;

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
        this.Email = Email;
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
        return Email;
    }

    public String getSexe() {
        return sexe;
    }

    public Utilisateur(String id, String nomuser, String pswrd, String email, String birth, String sexe) {
        this.id = id;
        this.nomuser = nomuser;
        this.pswrd = pswrd;
        Email = email;
        this.birth = birth;
        this.sexe = sexe;
    }

    public Utilisateur(String nomuser, String pswrd, String email, String birth, String sexe) {
        this.nomuser = nomuser;
        this.pswrd = pswrd;
        Email = email;
        this.birth = birth;
        this.sexe = sexe;
    }

    public Utilisateur() {
    }
}

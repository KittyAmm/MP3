package model;

import dao.BaseModele;

public class Personn extends BaseModele {
    private String nom;
    private String prenom;

    public Personn() {
    }

    public Personn(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }

    @Override
    public String toString() {
        return "Personn{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

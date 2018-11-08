package model;

import dao.BaseModele;

public class Personne extends BaseModele {
    private String nom;
    private String prenom;

    public Personne() {
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public String getPrenom() {
        return prenom;
    }
}

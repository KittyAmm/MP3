package model;

import dao.BaseModele;

public class Produit extends BaseModele{
    private String nom;
    private String daty;
    private Double prix;

    public Produit(String nom, String daty, double prix) {
        this.nom = nom;
        this.daty = daty;
        this.prix = prix;
    }

    public Produit() {
    }
}

package org.example;

public class Billet {
    private String type;
    private double prix;
    private String date;
    private int quantiteDisponible;
    private String nomUtilisateur; // Nouveau champ

    public Billet(String type, double prix, String date, int quantiteDisponible) {
        this.type = type;
        this.prix = prix;
        this.date = date;
        this.quantiteDisponible = quantiteDisponible;
        this.nomUtilisateur = null; // Par défaut, pas encore réservé
    }

    // Getters et Setters
    public String getType() { return type; }
    public double getPrix() { return prix; }
    public String getDate() { return date; }
    public int getQuantiteDisponible() { return quantiteDisponible; }
    public String getNomUtilisateur() { return nomUtilisateur; }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void decrementerQuantite() {
        if (this.quantiteDisponible > 0) {
            this.quantiteDisponible--;
        }
    }
}

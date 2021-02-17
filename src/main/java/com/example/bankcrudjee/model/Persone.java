package com.example.bankcrudjee.model;

public class Persone {
    private int id;
    private String nom;
    private String prenom;
    private Long numeroUser;
    private String userType;
    private double solde;


    public Persone(int id, String nom, String prenom, Long numeroUser, String userType, double solde) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroUser = numeroUser;
        this.userType = userType;
        this.solde = solde;
    }
    public Persone(Long numeroCompte, double solde, String userType, String nom, String prenom) {
        this.numeroUser = numeroUser;
        this.solde = solde;
        this.userType = userType;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getNumeroUser() {
        return numeroUser;
    }

    public void setNumeroUser(Long numeroUser) {
        this.numeroUser = numeroUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}

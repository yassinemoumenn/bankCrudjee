package com.example.bankcrudjee.model;

public class Entreprise {
    private int id;
    private String nom;
    private Long numeroUser;
    private String UserType;
    private double solde;

    public Entreprise(int id, String nom, Long numeroUser, String userType, double solde) {
        this.id = id;
        this.nom = nom;
        this.numeroUser = numeroUser;
        UserType = userType;
        this.solde = solde;
    }
    public Entreprise(Long numeroUser, double solde, String userType, String nom) {
        this.numeroUser = numeroUser;
        this.solde = solde;
        this.UserType = userType;
        this.nom = nom;
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

    public Long getNumeroUser() {
        return numeroUser;
    }

    public void setNumeroUser(Long numeroUser) {
        this.numeroUser = numeroUser;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}

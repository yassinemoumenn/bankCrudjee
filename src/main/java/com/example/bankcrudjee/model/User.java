package com.example.bankcrudjee.model;

public class User {
    private int id;
    private Long numeroUser;
    private double solde;
    private String userType;

    public User(int id, Long numeroUser, double solde, String userType) {
        this.id = id;
        this.numeroUser = numeroUser;
        this.solde = solde;
        this.userType = userType;

    }
    public User(Long numeroUser, double solde, String userType) {
        this.numeroUser = numeroUser;
        this.solde = solde;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumeroUser() {
        return numeroUser;
    }

    public void setNumeroUser(Long numeroUser) {
        this.numeroUser = numeroUser;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getUserType() {
        return userType;
    }


}

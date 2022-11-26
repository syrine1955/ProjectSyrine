package com.example.projectsyrine.Entites;

public class Contrat {

    private int id;
    private String reference;
    private String datedebut;
    private String datefin;
    private double redevence;
    private int idClient;

    public Contrat() {
    }

    public Contrat(int id, String reference, String datedebut, String datefin, double redevence, int idClient) {
        this.id = id;
        this.reference = reference;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.redevence = redevence;
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public double getRedevence() {
        return redevence;
    }

    public void setRedevence(double redevence) {
        this.redevence = redevence;
    }
}

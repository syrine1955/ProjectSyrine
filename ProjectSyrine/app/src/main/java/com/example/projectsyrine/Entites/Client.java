package com.example.projectsyrine.Entites;

public class Client {

    private int id;
    private String nom;
    private String adresse;
    private int tel;
    private int fax;
    private String contact;
    private int tel_Contact;

    public Client() {
    }

    public Client(int id, String nom, String adresse, int tel, int fax, String contact, int tel_Contact) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.fax = fax;
        this.contact = contact;
        this.tel_Contact = tel_Contact;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public int getFax() {
        return fax;
    }

    public String getContact() {
        return contact;
    }

    public int getTel_Contact() {
        return tel_Contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTel_Contact(int tel_Contact) {
        this.tel_Contact = tel_Contact;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel=" + tel +
                ", fax=" + fax +
                ", contact='" + contact + '\'' +
                ", tel_Contact=" + tel_Contact;
    }
}

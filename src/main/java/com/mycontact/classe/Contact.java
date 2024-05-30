package com.mycontact.classe;

public class Contact {
    private int id;
    private String nom;
    private String prenom;
    private String competence;

    public Contact(int id, String nom, String prenom, String competence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.competence = competence;
    }

    public Contact(String nom, String prenom, String competence) {
        this.nom = nom;
        this.prenom = prenom;
        this.competence = competence;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCompetence() {
        return competence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }
}

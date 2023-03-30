package org.application.Function007.AddPatient;

public class Patient {

    private int idPatient;
    private String nom ;
    private  String prenom ;
    private String tel ;
    private String  CIN ;
    private String sexe ;
    private  String dateNaissence ;
    private  String dateCreate ;
    private String etat ;

    public Patient(int idPatient, String nom, String prenom, String tel, String CIN, String sexe, String dateNaissence, String dateCreate, String etat) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.CIN = CIN;
        this.sexe = sexe;
        this.dateNaissence = dateNaissence;
        this.dateCreate = dateCreate;
        this.etat = etat;
    }

    public Patient(String nom, String prenom, String tel, String CIN, String sexe, String dateNaissence, String dateCreate, String etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.CIN = CIN;
        this.sexe = sexe;
        this.dateNaissence = dateNaissence;
        this.dateCreate = dateCreate;
        this.etat = etat;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getCIN() {
        return CIN;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDateNaissence() {
        return dateNaissence;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public String getEtat() {
        return etat;
    }
}

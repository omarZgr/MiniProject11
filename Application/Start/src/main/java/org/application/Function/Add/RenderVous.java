package org.application.Function.Add;

import java.util.Date;

public class RenderVous {

    private String nom ;
    private  String prenom ;
    private String tel ;
    private String  CIN ;
    private String sexe ;
    private  String lancer ;
    private String rendezVousDay ;

    public RenderVous(String nom, String prenom, String tel, String CIN, String sexe, String lancer, String rendezVousDay) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.CIN = CIN;
        this.sexe = sexe;
        this.lancer = lancer;
        this.rendezVousDay = rendezVousDay;
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

    public String getLancer() {
        return lancer;
    }

    public String getRendezVousDay() {
        return rendezVousDay;
    }



}

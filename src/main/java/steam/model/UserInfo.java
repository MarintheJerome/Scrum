package steam.model;

import org.bson.Document;

import java.util.Date;

/**
 * Created by Yhugo on 10/02/2017.
 */
public class UserInfo {

    public String nom;
    public String prenom;
    public String telephone;
    public String adresse;
    public Date dateNaissance;

    public UserInfo(String n, String p, String t, String a, Date date){
        this.nom=n;
        this.prenom=p;
        this.telephone=t;
        this.adresse=a;
        this.dateNaissance=date;
    }

    public UserInfo(Document document){
        this.nom = document.get("nom").toString();
        this.prenom = document.get("prenom").toString();
        this.telephone = document.get("telephone").toString();
        this.adresse = document.get("adresse").toString();
        this.dateNaissance = (java.sql.Date) document.get("datenaissance");
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

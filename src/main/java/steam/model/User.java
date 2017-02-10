package steam.model;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by Yhugo on 10/02/2017.
 */
public class User {

    public ObjectId id;
    public String login;
    public String mdp;
    public String nom;
    public String prenom;
    public String telephone;
    public String adresse;
    public Date dateNaissance;

    public User(String n, String p, String t, String a, Date date,String log, String mdp){
        this.nom=n;
        this.prenom=p;
        this.telephone=t;
        this.adresse=a;
        this.dateNaissance=date;
        this.login=log;
        this.mdp=mdp;
    }

    public User(Document document){
        this.nom = document.get("nom").toString();
        this.prenom = document.get("prenom").toString();
        this.telephone = document.get("telephone").toString();
        this.adresse = document.get("adresse").toString();
        this.dateNaissance = (java.sql.Date) document.get("datenaissance");
        this.login = document.get("login").toString();
        this.mdp = document.get("mdp").toString();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

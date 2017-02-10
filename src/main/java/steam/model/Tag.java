package steam.model;

import org.bson.Document;

/**
 * Created by jerome on 10/02/2017.
 */
public class Tag {
    private String nom;

    public Tag(String nom) {
        this.nom = nom;
    }

    public Tag(Document document){
        this.nom = document.get("nom").toString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

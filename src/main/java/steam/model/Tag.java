package steam.model;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by jerome on 10/02/2017.
 */
public class Tag {
    private ObjectId id;
    private String nom;

    public Tag(String nom) {
        this.nom = nom;
    }

    public Tag(Document document){
        this.id = (ObjectId) document.get("_id");
        this.nom = document.get("nom").toString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

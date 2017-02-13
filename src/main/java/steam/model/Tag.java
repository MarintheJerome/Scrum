package steam.model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by jerome on 10/02/2017.
 */
public class Tag {
    private ObjectId id;
    private String nom;

    static MongoClient mc ;
    static MongoDatabase mdb ;
    static MongoCollection collection;

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

    public void sauvegarder() {
        System.out.println("Sauvegarde tag "+nom+" par MongoDB");

        Document document = toDocument();

        mc = new MongoClient("localhost",27017);
        mdb = mc.getDatabase("Scrum");
        collection = mdb.getCollection("tags");

        collection.insertOne(document);
    }

    public Document toDocument() {
        Document db = new Document();
        db.put("nom", nom);
        return db;
    }
}

package steam.model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import steam.bdd.MongoDB;

/**
 * Created by jerome on 10/02/2017.
 */
public class Tag {
    private ObjectId id;
    private String nom;

    static MongoClient mc ;
    static MongoDatabase mdb ;
    static MongoCollection collection;

    public Tag() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

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
        Document document = toDocument();
        MongoDB mongo = MongoDB.getInstance();
        MongoCollection collection = mongo.mdb.getCollection("tags");
        collection.insertOne(document);
    }

    public Document toDocument() {
        Document db = new Document();
        db.put("nom", nom);
        return db;
    }

    public Tag withNewObjectId() {
        this.id = ObjectId.get();
        return this;
    }
}

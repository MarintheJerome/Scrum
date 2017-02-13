package steam.model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.ArrayList;

/**
 * Created by jerome on 10/02/2017.
 */
public class Game {
    private ObjectId id;
    private String name;
    private String shortDescription;
    private String fullDescription;
    private Date releaseDate;
    private ArrayList<Tag> tags;
    private String video;

    public Game(){

    }

    static MongoClient mc ;
    static MongoDatabase mdb ;
    static MongoCollection collection;

    public Game(String name, String shortDescription, String fullDescription, Date releaseDate, ArrayList<Tag> tags) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.releaseDate = releaseDate;
        this.tags = tags;
    }

    public Game(Document document){
        this.id = (ObjectId) document.get("_id");
        this.name = document.get("name").toString();
        this.shortDescription = document.get("shortDescription").toString();
        this.fullDescription = document.get("fullDescription").toString();
        this.releaseDate = (Date) document.get("date");
        this.tags = new ArrayList<>();
        ArrayList<Document> tagsMongo = (ArrayList<Document>) document.get("tags");
        for (Document tag : tagsMongo) {
            if (tag.get("tag") == null) {
                break;
            }
            this.tags.add(new Tag(tag));
        }
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVideo(){
        return this.video;
    }

    public void setVideo(String video){
        this.video = video;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public static void find(ObjectId game) {
    }

    public void sauvegarder() {
        System.out.println("Sauvegarde jeu "+name+"  par MongoDB");

        Document document = toDocument();

        mc = new MongoClient("localhost",27017);
        mdb = mc.getDatabase("Scrum");
        collection = mdb.getCollection("games");

        collection.insertOne(document);
    }

    public Document toDocument() {
        Document db = new Document();
        db.put("nom", name);
        db.put("shortDescription", shortDescription);
        db.put("fullDescription", fullDescription);
        db.put("realseDate", releaseDate);
        db.put("tags", tags);
        return db;
    }
}

package steam.model;

import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import steam.bdd.MongoDB;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by jerome on 10/02/2017.
 */
public class Game {
    private ObjectId id;
    private String name;
    private String shortDescription;
    private String fullDescription;
    private double price;
    private Date releaseDate;
    private ArrayList<Tag> tags;
    private String video;

    public Game(){

    }

    public Game(String name, String shortDescription, String fullDescription, Date releaseDate, ArrayList<Tag> tags) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.releaseDate = releaseDate;
        this.tags = tags;
    }

    public Game(String name, String shortDescription, String fullDescription, double price, String video, Date releaseDate, ArrayList<Tag> tags) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.price = price;
        this.video = video;
        this.releaseDate = releaseDate;
        this.tags = tags;
    }

    public Game(Document document){
        this.id = (ObjectId) document.get("_id");
        this.name = document.get("name").toString();
        this.shortDescription = document.get("shortdescription").toString();
        this.fullDescription = document.get("fulldescription").toString();
        this.video = document.get("video").toString();
        DateFormat df = new SimpleDateFormat("YYYY/MM/dd");
        Date startDate = null;
        try {
            startDate = df.parse(document.get("releasedate").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.releaseDate = startDate;
        this.tags = new ArrayList<>();
        ArrayList<String> tagsMongo = (ArrayList<String>) document.get("tags");
        for (String tag : tagsMongo) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Game getGameInfo(String name) {
        MongoDB mongo = MongoDB.getInstance();
        MongoCollection<Document> collection = mongo.mdb.getCollection("games");
        FindIterable<Document> games = collection.find();
        Game game;
        for (Document document : games) {
            game = new Game(document);
            if (game.getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public static ArrayList<Game> findAll(){
        ArrayList<Game> jeux = new ArrayList<>();
        MongoDB mongo = MongoDB.getInstance();
        MongoCollection<Document> collection = mongo.mdb.getCollection("games");
        FindIterable<Document> games = collection.find();
        Game game;
        for (Document document : games) {
            game = new Game(document);
            jeux.add(game);
        }
        return jeux;
    }

    public static void deleteGame(String name){
        BasicDBObject query = new BasicDBObject();
        MongoDB mongo = MongoDB.getInstance();
        MongoCollection<Document> collection = mongo.mdb.getCollection("games");
        FindIterable<Document> games = collection.find();
        Game game;
        for (Document document : games) {
            game = new Game(document);
            if (game.getName().equals(name)) {
                query.put("_id", game.getId());
                collection.deleteOne(query);
                break;
            }
        }
    }

    public void sauvegarder() {
        Document document = toDocument();
        MongoDB mongo = MongoDB.getInstance();
        MongoCollection collection = mongo.mdb.getCollection("games");
        collection.insertOne(document);
    }

    public Document toDocument() {
        Document db = new Document();
        db.put("nom", name);
        db.put("shortDescription", shortDescription);
        db.put("fullDescription", fullDescription);
        db.put("releaseDate", releaseDate);
        db.put("tags", tags);
        db.put("video", video);
        db.put("price", price);

        return db;
    }
}

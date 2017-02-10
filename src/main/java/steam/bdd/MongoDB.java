package steam.bdd;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSON;
import org.bson.Document;
import steam.model.Game;

import java.util.ArrayList;

/**
 * Created by jerome on 21/01/2017.
 */
public class MongoDB{
    private MongoClient mc;
    public MongoDatabase mdb;

    public static MongoDB mongoDB;

    public MongoDB(){
        mc = new MongoClient("localhost", 27017);
        mdb = mc.getDatabase("Scrum");
    }

    public Game getGameInfo(String name){
        MongoCollection<Document> collection = mdb.getCollection("games");
        FindIterable<Document> games = collection.find();
        Game game;
        for(Document document : games){
            game = new Game(document);
            if(game.getName().equals(name)){
                return game;
            }
        }
        return null;
    }

    public static synchronized MongoDB getInstance(){
        if(mongoDB != null){
            mongoDB = new MongoDB();
        }
        return mongoDB;
    }

    public ArrayList<Game> getGamesSearch(String name){
        ArrayList<Game> toReturn = new ArrayList<>();
        MongoCollection<Document> collection = mdb.getCollection("games");
        FindIterable<Document> games = collection.find();
        Game game;
        for(Document document : games){
            game = new Game(document);
            if(game.getName().contains(name)){
                toReturn.add(game);
            }
        }
        return toReturn;
    }
}
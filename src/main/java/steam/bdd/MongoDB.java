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
/**
 * Created by jerome on 21/01/2017.
 */
public class MongoDB{

    private MongoCollection<Document> collection;
    private MongoClient mc;
    private MongoDatabase mdb;

    public MongoDB(){
        mc = new MongoClient("localhost", 27017);
        mdb = mc.getDatabase("Scrum");
    }

    public Game getGameInfo(String name){
        collection = mdb.getCollection("games");
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
}
package steam.bdd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import steam.model.Game;
/**
 * Created by jerome on 21/01/2017.
 */
public class MongoDB{

    public MongoCollection<Document> collection;
    public MongoClient mc;
    public MongoDatabase mdb;
    public static MongoDB mongoDB;

    public MongoDB(){
        mc = new MongoClient("localhost", 27017);
        mdb = mc.getDatabase("Scrum");
    }

    public Game getGameInfo(String name){
        MongoCollection collection = mdb.getCollection("games");
        return null;
    }

    public static synchronized MongoDB getInstance(){
        if(mongoDB != null){
            mongoDB = new MongoDB();
        }
        return mongoDB;
    }


}
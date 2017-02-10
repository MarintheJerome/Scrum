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

    private MongoCollection<Document> collection;
    private MongoClient mc;
    private MongoDatabase mdb;

    public MongoDB(){
        mc = new MongoClient("localhost", 27017);
        mdb = mc.getDatabase("Scrum");
    }

    public Game getGameInfo(String name){
        return new Game();
    }
}
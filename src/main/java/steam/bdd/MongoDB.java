package steam.bdd;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

    private MongoDB(){
        mc = new MongoClient("localhost", 27017);
        mdb = mc.getDatabase("Scrum");
    }

    public static synchronized MongoDB getInstance(){
        if(mongoDB == null){
            mongoDB = new MongoDB();
        }
        return mongoDB;
    }
}
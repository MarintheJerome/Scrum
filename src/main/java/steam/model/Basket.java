package steam.model;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import steam.bdd.MongoDB;

import java.util.List;
import java.util.UUID;

/**
 * Created by nitix on 13/02/17.
 */
public class Basket{

    private ObjectId id;

    private ObjectId userId;

    private List<ObjectId> games;

    public List<ObjectId> getGames() {
        return games;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public void setGames(List<ObjectId> games) {
        this.games = games;
    }


    public void addGame(ObjectId gameId) {
        if(this.games.contains(gameId))
            this.games.add(gameId);
    }

    public static Basket getBasket(ObjectId userId) {
        BasicDBObject query = new BasicDBObject();
        query.put("userId", userId);
        MongoDatabase mdb = MongoDB.getInstance().mdb;
        MongoCollection<Basket> basketsColl = mdb.getCollection("baskets", Basket.class);
        return basketsColl.find(query).first();
    }

    public void removeGame(ObjectId gameId) {
        this.games.remove(gameId);
    }

    public void upsert() {
        MongoDatabase mdb = MongoDB.getInstance().mdb;
        MongoCollection<Basket> basketsColl = mdb.getCollection("baskets", Basket.class);
        basketsColl.insertOne(this);
    }

    public Basket withNewObjectId() {
        this.id = ObjectId.get();
        return this;
    }
}

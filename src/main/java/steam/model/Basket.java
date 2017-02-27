package steam.model;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.operation.FindAndReplaceOperation;
import org.bson.Document;
import org.bson.types.ObjectId;
import steam.bdd.MongoDB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by nitix on 13/02/17.
 */
public class Basket{

    private ObjectId id;

    private String login;

    private List<ObjectId> games = new ArrayList<>();

    public List<ObjectId> getGames() {
        return games;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return login;
    }

    public void setUserId(String login) {
        this.login = login;
    }

    public void setGames(List<ObjectId> games) {
        if(games == null){
            this.games = new ArrayList<>();
        }
        this.games = games;
    }


    public void addGame(ObjectId gameId) {
        if(this.games.contains(gameId))
            this.games.add(gameId);
    }

    public static Basket getBasket(String userId) {
        BasicDBObject query = new BasicDBObject();
        query.put("userId", userId);
        MongoDatabase mdb = MongoDB.getInstance().mdb;
        MongoCollection<Basket> basketsColl = mdb.getCollection("baskets", Basket.class);
        Basket basket = basketsColl.find(query).first();
        if(basket == null){
            basket = new Basket();
            basket.setUserId(userId);
        }
        return basket;
    }

    public void removeGame(ObjectId gameId) {
        this.games.remove(gameId);
    }

    public void upsert() {
        BasicDBObject query = new BasicDBObject();
        query.put("userId", getUserId());
        MongoDatabase mdb = MongoDB.getInstance().mdb;
        MongoCollection<Basket> basketsColl = mdb.getCollection("baskets", Basket.class);
        UpdateOptions options = new UpdateOptions().upsert(true);
        basketsColl.replaceOne(query, this, options);
    }

    public Basket withNewObjectId() {
        this.id = ObjectId.get();
        return this;
    }
}

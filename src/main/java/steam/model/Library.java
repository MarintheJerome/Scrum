package steam.model;

import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import steam.bdd.MongoDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nitix on 10/02/17.
 */
public class Library {

    private ObjectId userId;

    private List<LibraryEntry> entries;

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public List<LibraryEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<LibraryEntry> entries) {
        this.entries = entries;
    }

    public static Library find(Object userId) {
        MongoDB mongoDB = MongoDB.getInstance();
        MongoCollection<Library> libDoc = mongoDB.mdb.getCollection("libraries", Library.class);
        BasicDBObject query = new BasicDBObject();
        query.put("userId", userId);
        return libDoc.find(query).first();
    }
}

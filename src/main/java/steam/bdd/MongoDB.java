package steam.bdd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import steam.model.Basket;
import steam.model.BasketCodec;
import steam.model.Game;
import steam.model.GameCodec;

import java.util.ArrayList;

/**
 * Created by jerome on 21/01/2017.
 */
public class MongoDB{
    private MongoClient mc;
    public MongoDatabase mdb;

    public static MongoDB mongoDB;

    private MongoDB(){

        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(new BasketCodec(), new GameCodec())
        );

        MongoClientOptions options =
                MongoClientOptions.builder()
                        .codecRegistry(codecRegistry)
                        .build();
        mc = new MongoClient("localhost:27017", options);
        mdb = mc.getDatabase("Scrum");
    }

    public static synchronized MongoDB getInstance(){
        if(mongoDB == null){
            mongoDB = new MongoDB();
        }
        return mongoDB;
    }
}
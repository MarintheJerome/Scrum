package steam.model;

import org.bson.*;
import org.bson.codecs.*;

import java.util.Date;

/**
 * Created by Nicochu on 27/02/2017.
 */
public class GameCodec  implements CollectibleCodec<Game> {
    private Codec<Document> documentCodec;

    public GameCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public GameCodec(Codec<Document> codec) {
        this.documentCodec = codec;
    }


    public void encode(BsonWriter writer, Game value,
                       EncoderContext encoderContext) {
        Document document = new Document();
        if(value.getId() != null)
            document.put("_id", value.getId());
        if(value.getName() != null)
            document.put("nom", value.getName());
        if(value.getShortDescription() != null)
            document.put("shortDescription", value.getShortDescription());
        if(value.getFullDescription() != null)
            document.put("fullDescription", value.getFullDescription());
        if(value.getReleaseDate() != null)
            document.put("releaseDate", value.getReleaseDate());
        if(value.getTags() != null)
            document.put("tags", value.getTags());
        documentCodec.encode(writer, document, encoderContext);
    }


    public Class<Game> getEncoderClass() {
        return Game.class;
    }


    public Game decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        System.out.println("document "+document);
        Game game = new Game();

        game.setId(document.getObjectId("_id"));
        game.setName((String)document.get("nom"));
        game.setShortDescription((String)document.get("shortDescription"));
        game.setFullDescription((String)document.get("fullDescription"));
        game.setReleaseDate((Date)document.get("fullDescription"));

        return game;
    }


    public Game generateIdIfAbsentFromDocument(Game document) {
        return documentHasId(document) ? document.withNewObjectId() : document;
    }


    public boolean documentHasId(Game document) {
        return null == document.getId();
    }


    public BsonValue getDocumentId(Game document) {
        if (!documentHasId(document))
        {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(document.getId().toHexString());
    }

}

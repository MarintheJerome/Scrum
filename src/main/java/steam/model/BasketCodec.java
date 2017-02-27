package steam.model;

import org.bson.*;
import org.bson.codecs.*;

import java.util.ArrayList;

/**
 * Created by nitix on 13/02/17.
 */
public class BasketCodec implements CollectibleCodec<Basket> {

    private Codec<Document> documentCodec;

    public BasketCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public BasketCodec(Codec<Document> codec) {
        this.documentCodec = codec;
    }

    @Override
    public void encode(BsonWriter writer, Basket value,
                       EncoderContext encoderContext) {
        Document document = new Document();
        if(value.getId() != null)
            document.put("_id", value.getId());
        if(value.getUserId() != null)
            document.put("userId", value.getUserId());
        if(value.getGames() != null)
            document.put("games", value.getGames());
        documentCodec.encode(writer, document, encoderContext);
    }

    @Override
    public Class<Basket> getEncoderClass() {
        return Basket.class;
    }

    @Override
    public Basket decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        System.out.println("document "+document);
        Basket basket = new Basket();

        basket.setId(document.getObjectId("_id"));

        basket.setUserId(document.getString("userId"));

        basket.setGames(document.get("games", ArrayList.class));

        return basket;
    }

    @Override
    public Basket generateIdIfAbsentFromDocument(Basket document) {
        return documentHasId(document) ? document.withNewObjectId() : document;
    }

    @Override
    public boolean documentHasId(Basket document) {
        return null == document.getId();
    }

    @Override
    public BsonValue getDocumentId(Basket document) {
        if (!documentHasId(document))
        {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(document.getId().toHexString());
    }
}

package steam.model;

import org.bson.*;
import org.bson.codecs.*;

import java.util.Date;

/**
 * Created by Nicochu on 27/02/2017.
 */
public class TagCodec implements CollectibleCodec<Tag> {
    private Codec<Document> documentCodec;

    public TagCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public TagCodec(Codec<Document> codec) {
        this.documentCodec = codec;
    }


    public void encode(BsonWriter writer, Tag value,
                       EncoderContext encoderContext) {
        Document document = new Document();
        if(value.getId() != null)
            document.put("_id", value.getId());
        if(value.getNom() != null)
            document.put("nom", value.getNom());
        documentCodec.encode(writer, document, encoderContext);
    }


    public Class<Tag> getEncoderClass() {
        return Tag.class;
    }


    public Tag decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        System.out.println("document "+document);
        Tag tag = new Tag();

        tag.setId(document.getObjectId("_id"));
        tag.setNom((String)document.get("nom"));

        return tag;
    }


    public Tag generateIdIfAbsentFromDocument(Tag document) {
        return documentHasId(document) ? document.withNewObjectId() : document;
    }


    public boolean documentHasId(Tag document) {
        return null == document.getId();
    }


    public BsonValue getDocumentId(Tag document) {
        if (!documentHasId(document))
        {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(document.getId().toHexString());
    }

}

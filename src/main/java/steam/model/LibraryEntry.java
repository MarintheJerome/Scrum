package steam.model;

import org.bson.types.ObjectId;

/**
 * Created by nitix on 10/02/17.
 */
public class LibraryEntry {

    private ObjectId game;

    private String cle;


    public ObjectId getGame() {
        return game;
    }

    public void setGame(ObjectId game) {
        this.game = game;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }
}

package steam.model;

import org.bson.Document;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by jerome on 10/02/2017.
 */
public class Game {
    private String name;
    private String shortDescription;
    private String fullDescription;
    private Date releaseDate;
    private ArrayList<Tag> tags;

    public Game(String name, String shortDescription, String fullDescription, Date releaseDate, ArrayList<Tag> tags) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.releaseDate = releaseDate;
        this.tags = tags;
    }

    public Game(Document document){
        this.name = document.get("name").toString();
        this.shortDescription = document.get("shortDescription").toString();
        this.fullDescription = document.get("fullDescription").toString();
        this.releaseDate = (Date) document.get("date");
        this.tags = new ArrayList<>();
        ArrayList<Document> tagsMongo = (ArrayList<Document>) document.get("tags");
        for (Document tag : tagsMongo) {
            if (tag.get("tag") == null) {
                break;
            }
            this.tags.add(new Tag(tag));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}

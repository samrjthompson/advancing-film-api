package uk.co.advancingfilm.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "film_stocks")
public class FilmStockDocument {

    @Id
    private String id;
    private String name;
    private Metadata metadata;
    private int iso;
    private String format;
    private boolean isColour;
    private String type;
    private String description;
    private String sampleImageUrl;

    public String getId() {
        return id;
    }

    public FilmStockDocument id(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FilmStockDocument name(String name) {
        this.name = name;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public FilmStockDocument metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public int getIso() {
        return iso;
    }

    public FilmStockDocument iso(int iso) {
        this.iso = iso;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public FilmStockDocument format(String format) {
        this.format = format;
        return this;
    }

    public boolean isColour() {
        return isColour;
    }

    public FilmStockDocument colour(boolean colour) {
        isColour = colour;
        return this;
    }

    public String getType() {
        return type;
    }

    public FilmStockDocument type(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmStockDocument description(String description) {
        this.description = description;
        return this;
    }

    public String getSampleImageUrl() {
        return sampleImageUrl;
    }

    public FilmStockDocument sampleImageUrl(String sampleImageUrl) {
        this.sampleImageUrl = sampleImageUrl;
        return this;
    }
}
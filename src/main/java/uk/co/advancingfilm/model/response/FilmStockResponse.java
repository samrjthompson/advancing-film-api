package uk.co.advancingfilm.model.response;

public class FilmStockResponse {

    private String id;
    private String name;
    private int iso;
    private String format;
    private boolean isColour;
    private String type;
    private String description;
    private String sampleImageUrl;

    public String getId() {
        return id;
    }

    public FilmStockResponse id(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FilmStockResponse name(String name) {
        this.name = name;
        return this;
    }

    public int getIso() {
        return iso;
    }

    public FilmStockResponse iso(int iso) {
        this.iso = iso;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public FilmStockResponse format(String format) {
        this.format = format;
        return this;
    }

    public boolean isColour() {
        return isColour;
    }

    public FilmStockResponse colour(boolean colour) {
        isColour = colour;
        return this;
    }

    public String getType() {
        return type;
    }

    public FilmStockResponse type(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FilmStockResponse description(String description) {
        this.description = description;
        return this;
    }

    public String getSampleImageUrl() {
        return sampleImageUrl;
    }

    public FilmStockResponse sampleImageUrl(String sampleImageUrl) {
        this.sampleImageUrl = sampleImageUrl;
        return this;
    }
}

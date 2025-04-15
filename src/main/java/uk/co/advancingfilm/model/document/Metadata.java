package uk.co.advancingfilm.model.document;

public class Metadata {

    private String stockId;

    public String getStockId() {
        return stockId;
    }

    public Metadata stockId(String stockId) {
        this.stockId = stockId;
        return this;
    }
}
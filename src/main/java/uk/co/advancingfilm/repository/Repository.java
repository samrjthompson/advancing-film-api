package uk.co.advancingfilm.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import uk.co.advancingfilm.model.document.FilmStockDocument;

@Component
public class Repository {

    private final MongoTemplate mongoTemplate;

    public Repository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public FilmStockDocument getSingleDocument(final String metadataId) {
        Query query = Query.query(Criteria.where("metadata.stockId").is(metadataId));
        return mongoTemplate.findOne(query, FilmStockDocument.class);
    }
}

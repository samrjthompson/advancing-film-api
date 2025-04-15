package uk.co.advancingfilm.mapper;

import org.springframework.stereotype.Component;
import uk.co.advancingfilm.model.document.FilmStockDocument;
import uk.co.advancingfilm.model.response.FilmStockResponse;

@Component
public class FilmStockResponseMapper {

    public FilmStockResponse map(FilmStockDocument document) {
        return new FilmStockResponse()
                .id(document.getId())
                .description(document.getDescription())
                .iso(document.getIso())
                .format(document.getFormat())
                .colour(document.isColour())
                .name(document.getName())
                .sampleImageUrl(document.getSampleImageUrl())
                .type(document.getType());
    }
}

package uk.co.advancingfilm.service;

import java.util.List;
import org.springframework.stereotype.Component;
import uk.co.advancingfilm.mapper.FilmStockResponseMapper;
import uk.co.advancingfilm.model.document.FilmStockDocument;
import uk.co.advancingfilm.model.response.FilmStockResponse;
import uk.co.advancingfilm.repository.Repository;

@Component
public class Service {

    private final Repository repository;
    private final FilmStockResponseMapper filmStockResponseMapper;

    public Service(Repository repository, FilmStockResponseMapper filmStockResponseMapper) {
        this.repository = repository;
        this.filmStockResponseMapper = filmStockResponseMapper;
    }

    public FilmStockResponse getFilmStock() {
        FilmStockDocument doc = repository.getSingleDocument("portra400");
        return filmStockResponseMapper.map(doc);
    }

    public List<FilmStockResponse> getAllFilmStocks() {
        return null;
    }
}

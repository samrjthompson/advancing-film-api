package uk.co.advancingfilm.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.advancingfilm.model.response.FilmStockResponse;
import uk.co.advancingfilm.service.Service;

@CrossOrigin
@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/film-stocks/{film_stock}")
    public ResponseEntity<FilmStockResponse> getFilmStock(
            @PathVariable("film_stock") final String filmStock) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getFilmStock());
    }

    @GetMapping("/film-stocks")
    public ResponseEntity<List<FilmStockResponse>> getAllFilmStocks() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllFilmStocks());
    }
}

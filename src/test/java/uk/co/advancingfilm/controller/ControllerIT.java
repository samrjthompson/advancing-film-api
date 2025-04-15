package uk.co.advancingfilm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class ControllerIT extends AbstractControllerIT {

    private static final String GET_SINGLE_FILM_STOCK_URI = "/film-stocks/{film_stock}";
    private static final String PORTRA_400_METADATA_ID = "portra400";

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @BeforeEach
    void setUp() throws Exception {
        mongoTemplate.dropCollection(DATABASE);
        mongoTemplate.createCollection(DATABASE);

        final String doc = getJsonAsString("/film_stock_document.json");
        mongoTemplate.insert(doc, FILM_STOCK_COLLECTION);
    }

    @Test
    void shouldReturnSingleDocument() throws Exception {
        // given
        final String expected = getJsonAsString("/response/single_film_stock_response.json");

        // when
        ResultActions result = mockMvc.perform(get(GET_SINGLE_FILM_STOCK_URI, PORTRA_400_METADATA_ID));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        assertJsonResult(result, expected);
    }


}

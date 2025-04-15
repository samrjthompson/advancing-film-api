package uk.co.advancingfilm.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StringUtils;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest
class AbstractControllerIT {

    protected static final String DATABASE = "advancing_film";
    protected static final String FILM_STOCK_COLLECTION = "film_stocks";

    @Container
    protected static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:8.0.6");

    @Autowired
    protected MongoTemplate mongoTemplate;
    @Autowired
    protected MockMvc mockMvc;

    protected static String getJsonAsString(final String path) throws Exception {
        return IOUtils.resourceToString(path, StandardCharsets.UTF_8);
    }

    protected static void assertJsonResult(ResultActions result, final String expected) throws Exception {
        JSONCompareResult jsonResult = JSONCompare.compareJSON(expected,
                result.andReturn().getResponse().getContentAsString(),
                JSONCompareMode.LENIENT);
        assertFalse(StringUtils.hasText(jsonResult.getMessage()));
        assertTrue(jsonResult.passed());
    }
}

package uk.co.advancingfilm.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import uk.co.advancingfilm.model.document.FilmStockDocument;

@ExtendWith(MockitoExtension.class)
class RepositoryTest {

    private static final String PORTRA_400_METADATA_ID = "portra400";

    @Mock
    private MongoTemplate mongoTemplate;
    @InjectMocks
    private Repository repository;

    @Mock
    private FilmStockDocument filmStockDocument;

    @Test
    void shouldGetSingleDocument() {
        // given
        when(mongoTemplate.findOne(any(Query.class), any())).thenReturn(filmStockDocument);
        Query query = Query.query(Criteria.where("metadataName").is(PORTRA_400_METADATA_ID));

        // when
        final FilmStockDocument actual = repository.getSingleDocument(PORTRA_400_METADATA_ID);

        // then
        assertEquals(filmStockDocument, actual);
        verify(mongoTemplate).findOne(query, FilmStockDocument.class);
        verifyNoMoreInteractions(mongoTemplate);
    }
}
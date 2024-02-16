package thesaurus.demo;
import thesaurus.demo.services.ThesaurusServiceInterface;
import thesaurus.demo.controllers.ThesaurusController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ThesaurusControllerTests {

    @Test
    void testThesaurusController() {
        ThesaurusServiceInterface thesaurusService = Mockito.mock(ThesaurusServiceInterface.class);
        ThesaurusController thesaurusController = new ThesaurusController(thesaurusService);

        Set<String> expectedSynonyms = new HashSet<>(Set.of("joyful", "content"));
        Set<String> expectedTransitiveSynonyms = new HashSet<>(Set.of("joyful", "delighted"));

        when(thesaurusService.getSynonyms("happy")).thenReturn(expectedSynonyms);
        when(thesaurusService.getTransitiveSynonyms("happy")).thenReturn(expectedTransitiveSynonyms);

        Set<String> synonyms = thesaurusController.getSynonyms("happy");
        Set<String> transitiveSynonyms = thesaurusController.getTransitiveSynonyms("happy");

        assertEquals(expectedSynonyms, synonyms);
        assertEquals(expectedTransitiveSynonyms, transitiveSynonyms);
    }
}

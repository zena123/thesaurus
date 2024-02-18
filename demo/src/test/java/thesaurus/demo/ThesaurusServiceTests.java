package thesaurus.demo;
import thesaurus.demo.services.ThesaurusServiceInterface;
import thesaurus.demo.services.ThesaurusService;
import thesaurus.demo.models.SynonymGraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ThesaurusServiceTests {

    @Test
    void testAddSynonym() {
        SynonymGraph synonymGraph = new SynonymGraph();
        ThesaurusServiceInterface thesaurusService = new ThesaurusService(synonymGraph);

        thesaurusService.addSynonym("happy", "joyful");
        thesaurusService.addSynonym("B", "A");

        Set<String> synonyms = thesaurusService.getSynonyms("happy");

        assertEquals(1, synonyms.size());
        assertEquals(new HashSet<>(Set.of("joyful")), synonyms);
    }

    @Test
    void testGetSynonyms() {
        SynonymGraph synonymGraph = new SynonymGraph();
        ThesaurusService thesaurusService = new ThesaurusService(synonymGraph);

        thesaurusService.addSynonym("happy", "joyful");
        thesaurusService.addSynonym("happy", "content");

        Set<String> synonyms = thesaurusService.getSynonyms("happy");

        assertEquals(2, synonyms.size());
        assertEquals(new HashSet<>(Set.of("joyful", "content")), synonyms);
    }

    @Test
    void testGetTransitiveSynonyms() {
        SynonymGraph synonymGraph = new SynonymGraph();
        ThesaurusService thesaurusService = new ThesaurusService(synonymGraph);

        thesaurusService.addSynonym("A", "B");
        thesaurusService.addSynonym("B", "C");

        Set<String> transitiveSynonyms = thesaurusService.getTransitiveSynonyms("B");

        assertEquals(2, transitiveSynonyms.size());
        assertEquals(new HashSet<>(Set.of("A", "C")), transitiveSynonyms);
    }
}

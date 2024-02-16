package thesaurus.demo;
import thesaurus.demo.models.SynonymGraph;
import thesaurus.demo.operator.Dfs;
import thesaurus.demo.operator.SearchClass;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SynonymGraphTests {

    @Test
    void testAddSynonym() {
        SynonymGraph synonymGraph = new SynonymGraph();

        synonymGraph.addSynonym("B", "A");
        synonymGraph.addSynonym("D", "C");

        Set<String> synonyms = synonymGraph.getSynonyms("B");

        assertEquals(1, synonyms.size());
        assertEquals(new HashSet<>(Set.of("A")), synonyms);
    }

    @Test
    void testGetSynonyms() {
        SynonymGraph synonymGraph = new SynonymGraph();

        synonymGraph.addSynonym("B", "A");
        synonymGraph.addSynonym("B", "C");

        Set<String> synonyms = synonymGraph.getSynonyms("B");

        assertEquals(2, synonyms.size());
        assertEquals(new HashSet<>(Set.of("A", "C")), synonyms);
    }

    @Test
    void testGetTransitiveSynonyms() {
        SynonymGraph synonymGraph = new SynonymGraph();
         SearchClass searcher = new Dfs(synonymGraph); 

        synonymGraph.setSearcher(searcher);

        synonymGraph.addSynonym("A", "B");
        synonymGraph.addSynonym("B", "C");

        Set<String> transitiveSynonyms = synonymGraph.getTransitiveSynonyms("B");

        assertEquals(2, transitiveSynonyms.size());
        assertEquals(new HashSet<>(Set.of("A", "C")), transitiveSynonyms);
    }
}

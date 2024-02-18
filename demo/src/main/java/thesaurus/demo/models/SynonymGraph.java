package thesaurus.demo.models;
import org.springframework.stereotype.Component;

import lombok.Setter;
import thesaurus.demo.operator.SearchClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
public class SynonymGraph {
    private Map<String, Set<String>> graph;
    @Setter
    private SearchClass searcher;

    public SynonymGraph() {
        this.graph = new HashMap<>();
    }


    public void addSynonym(String word, String synonym) {
        graph.computeIfAbsent(word, k -> new HashSet<>()).add(synonym);
        graph.computeIfAbsent(synonym, k -> new HashSet<>()).add(word);
    }

    public Set<String> getSynonyms(String word) {
        return graph.getOrDefault(word, new HashSet<>());
    }

    public Set<String> getTransitiveSynonyms(String word) {
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        this.searcher.search(word, visited, result);
        result.remove(word);
        return result;
    }



}
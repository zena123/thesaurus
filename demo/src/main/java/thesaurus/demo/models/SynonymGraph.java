package thesaurus.demo.models;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
public class SynonymGraph {
    private Map<String, Set<String>> graph;

    public SynonymGraph() {
        this.graph = new HashMap<>();
    }

    public void addSynonym(String word, String synonym) {
        graph.computeIfAbsent(word, k -> new HashSet<>()).add(synonym);
        graph.computeIfAbsent(synonym, k -> new HashSet<>()).add(word);
    }

    public Set<String> getSynonyms(String word) {
        System.out.println(graph.getOrDefault(word, new HashSet<>()));
        return graph.getOrDefault(word, new HashSet<>());
    }

    public Set<String> getTransitiveSynonyms(String word) {
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        dfs(word, visited, result);
        System.out.println("......");
        result.remove(word);
        System.out.println(result);
        return result;
    }

    private void dfs(String start, Set<String> visited, Set<String> result) {
        visited.add(start);
        result.add(start);

        for (String synonym : graph.getOrDefault(start, new HashSet<>())) {
            if (!visited.contains(synonym)) {
                dfs(synonym, visited, result);
            }
        }
    }

    public void printGraph() {
        System.out.println("Synonym Graph:");
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
package thesaurus.demo.operator;

import java.util.Set;

import thesaurus.demo.models.SynonymGraph;

public class Dfs extends SearchClass {

    public Dfs(SynonymGraph graph){
        super(graph);
    }

    @Override
    public void search(String start, Set<String> visited, Set<String> result) {
        visited.add(start);
        result.add(start);
        for (String synonym : graph.getSynonyms(start)) {
            if (!visited.contains(synonym)) {
                search(synonym, visited, result);
            }
        }
        
    }
    
}

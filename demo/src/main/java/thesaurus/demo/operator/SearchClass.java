package thesaurus.demo.operator;
import lombok.AllArgsConstructor;

import java.util.Set;

import thesaurus.demo.models.SynonymGraph;
@AllArgsConstructor
public abstract class  SearchClass {
    protected SynonymGraph graph;
    // @Setter
    // private String start;

    public abstract void search(String start, Set<String> visited, Set<String> result);
    
}

package thesaurus.demo.services;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thesaurus.demo.models.SynonymGraph;

@Service
public class ThesaurusService implements ThesaurusServiceInterface{
    private final SynonymGraph synonymGraph;

    @Autowired
    public ThesaurusService(SynonymGraph synonymGraph) {
        this.synonymGraph = synonymGraph;
    }

    @Override
    public void addSynonym(String word, String synonym) {
        synonymGraph.addSynonym(word, synonym);
    }

    @Override
    public Set<String> getSynonyms(String word) {
        return synonymGraph.getSynonyms(word);
    }

    @Override
    public Set<String> getTransitiveSynonyms(String word) {
        return synonymGraph.getTransitiveSynonyms(word);
    }
}
    

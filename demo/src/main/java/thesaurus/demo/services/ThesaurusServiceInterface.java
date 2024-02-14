package thesaurus.demo.services;

import java.util.Set;

public interface ThesaurusServiceInterface {
    void addSynonym(String word, String synonym);

    Set<String> getSynonyms(String word);

    Set<String> getTransitiveSynonyms(String word);
}
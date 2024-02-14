package thesaurus.demo.controllers;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import thesaurus.demo.services.ThesaurusServiceInterface;

@RestController
@RequestMapping("/thesaurus")
public class ThesaurusController {
    private final ThesaurusServiceInterface thesaurusService;

    @Autowired
    public ThesaurusController(ThesaurusServiceInterface thesaurusService) {
        this.thesaurusService = thesaurusService;
    }

    @PostMapping("/add-synonym")
    public void addSynonym(@RequestParam String word, @RequestParam String synonym) {
        thesaurusService.addSynonym(word, synonym);
    }

    @GetMapping("/get-synonyms")
    public Set<String> getSynonyms(@RequestParam String word) {
        return thesaurusService.getSynonyms(word);
    }

    @GetMapping("/get-transitive-synonyms")
    public Set<String> getTransitiveSynonyms(@RequestParam String word) {
        return thesaurusService.getTransitiveSynonyms(word);
    }
}

package thesaurus.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import thesaurus.demo.models.SynonymGraph;
import thesaurus.demo.operator.Dfs;
import thesaurus.demo.operator.SearchClass;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		// SynonymGraph s  = new SynonymGraph();
		// SearchClass sc = new Dfs(s);
		// s.setSearcher(sc);
		// s.addSynonym("hi", "hello");
		// s.addSynonym("hello", "holla");
		// s.addSynonym("B", "A");
		// s.addSynonym("C", "B");
		// s.getSynonyms("hello");
		// s.getSynonyms("C");
		// s.getTransitiveSynonyms("C");
		// s.printGraph();
	}

}

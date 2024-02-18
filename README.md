# thesaurus

### Prerequisites

Before you begin, make sure you have the following installed:

- Java Development Kit (JDK)
- Maven

### Building the Project

```bash
mvn clean install
```

### Running tests

- cd demo
- mvn test

### Running Application
- mvn spring-boot:run




### Endpoints

- Add Synonym:
    - Endpoint: /thesaurus/add-synonym
    - Method: POST
    - Parameters:
        - word: The base word.
        - synonym: The synonym to add.

- Get Synonyms:
    - Endpoint: /thesaurus/get-synonyms
    - Method: GET
    - Parameters:
        - word: The word to retrieve synonyms for.

- Get Transitive Synonyms:
    - Endpoint: /thesaurus/get-transitive-synonyms
    - Method: GET
    - Parameters:
        - word: The word to retrieve transitive synonyms for.

### Description
- Data structures used: Undirected unweighted graph implemented using adjacency list
- Algorithm used: Depth First Search (DFS) is used to  implement a transitive rule given a word

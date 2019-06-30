package br.com.developernation.nationapi.repository;

import br.com.developernation.nationapi.models.Suggestion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionsRepository extends ReactiveMongoRepository<Suggestion, String> {

}

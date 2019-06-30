package br.com.developernation.nationapi.services.suggestion;

import br.com.developernation.nationapi.models.Suggestion;
import br.com.developernation.nationapi.models.User;
import br.com.developernation.nationapi.services.CrudService;
import reactor.core.publisher.Mono;

public interface SuggestionService extends CrudService<Suggestion> {

    Mono<Suggestion> acceptSuggestion(String id, User user);

    Mono<Suggestion> declineSuggestion(String id, User user);

    Mono<Suggestion> removeVote(String id, User user);

}

package br.com.developernation.nationapi.services.suggestion;

import br.com.developernation.nationapi.core.suggestions.SuggestionVote;
import br.com.developernation.nationapi.core.suggestions.SuggestionVoteType;
import br.com.developernation.nationapi.models.Suggestion;
import br.com.developernation.nationapi.models.User;
import br.com.developernation.nationapi.repository.SuggestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private SuggestionsRepository suggestionsRepository;

    @Autowired
    public SuggestionServiceImpl(SuggestionsRepository suggestionsRepository){
        this.suggestionsRepository = suggestionsRepository;
    }

    @Override
    public Flux<Suggestion> create(Mono<Suggestion> entity) {
        return this.suggestionsRepository.insert(entity);
    }

    @Override
    public Flux<Suggestion> findAll() {
        return this.suggestionsRepository.findAll();
    }

    @Override
    public Mono<Suggestion> findBy(Mono<String> id) {
        return this.suggestionsRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(Mono<String> id) {
        return this.suggestionsRepository.deleteById(id);
    }

    @Override
    public Mono<Suggestion> save(Suggestion entity) {
        return this.suggestionsRepository.save(entity);
    }

    @Override
    public Mono<Suggestion> acceptSuggestion(String id, User user) {
       return this.suggestionsRepository.findById(id).map(suggestion -> {
           suggestion.addVote(new SuggestionVote(user, SuggestionVoteType.ACCEPT));
           return suggestion;
       });
    }

    @Override
    public Mono<Suggestion> declineSuggestion(String id, User user) {
        return this.suggestionsRepository.findById(id).map(suggestion -> {
            suggestion.addVote(new SuggestionVote(user, SuggestionVoteType.DECLINE));
            return suggestion;
        });
    }

    @Override
    public Mono<Suggestion> removeVote(String id, User user) {
        return this.suggestionsRepository.findById(id).map(suggestion -> {
            suggestion.removeVote(user);
            return suggestion;
        });
    }
}

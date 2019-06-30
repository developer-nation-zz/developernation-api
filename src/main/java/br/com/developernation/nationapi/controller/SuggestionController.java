package br.com.developernation.nationapi.controller;

import br.com.developernation.nationapi.models.Suggestion;
import br.com.developernation.nationapi.models.User;
import br.com.developernation.nationapi.services.suggestion.SuggestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    private SuggestionServiceImpl suggestionService;

    @Autowired
    public SuggestionController(SuggestionServiceImpl suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping(path = "", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Suggestion> getSuggestions(){
        return this.suggestionService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Suggestion> getSuggestion(@PathVariable("id") String id) {
        return this.suggestionService.findBy(Mono.just(id));
    }

    @PostMapping(path = "", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Suggestion> postSuggestions(@RequestBody Suggestion body){
        return this.suggestionService.create(Mono.just(body));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteSuggestion(@PathVariable("id") String id){
        return this.suggestionService.deleteById(Mono.just(id));
    }

    @PostMapping(path = "/{id}/accept", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Suggestion> acceptSuggestion(@PathVariable("id") String id, @RequestBody User body){
        return this.suggestionService.acceptSuggestion(id, body);
    }

    @PostMapping(path = "/{id}/decline", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Suggestion> declineSuggestion(@PathVariable("id") String id, @RequestBody User body){
        return this.suggestionService.declineSuggestion(id, body);
    }

}

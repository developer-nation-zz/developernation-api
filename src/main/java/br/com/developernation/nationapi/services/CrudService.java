package br.com.developernation.nationapi.services;

import br.com.developernation.nationapi.models.AbstractModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T extends AbstractModel> {

    Flux<T> create(Mono<T> entity);

    Flux<T> findAll();

    Mono<T> findBy(Mono<String> id);

    Mono<Void> deleteById(Mono<String> id);

    Mono<T> save(T entity);

}

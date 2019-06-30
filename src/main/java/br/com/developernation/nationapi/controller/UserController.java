package br.com.developernation.nationapi.controller;


import br.com.developernation.nationapi.models.User;
import br.com.developernation.nationapi.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUser(@PathVariable("id") String id){
        return this.userService.findBy(Mono.just(id));
    }

    @PostMapping(path = "", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<User> postUser(@RequestBody User user){
        return this.userService.create(Mono.just(user));
    }
}

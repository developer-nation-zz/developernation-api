package br.com.developernation.nationapi.services.user;

import br.com.developernation.nationapi.models.User;
import br.com.developernation.nationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Flux<User> create(Mono<User> entity) {
        return this.userRepository.insert(entity);
    }

    @Override
    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Mono<User> findBy(Mono<String> id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(Mono<String> id) {
        return this.userRepository.deleteById(id);
    }

    @Override
    public Mono<User> save(User entity) {
        return this.userRepository.save(entity);
    }
}

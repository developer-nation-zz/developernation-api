package br.com.developernation.nationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories({"br.com.developernation.nationapi.repository"})
public class NationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NationApplication.class, args);
    }

}

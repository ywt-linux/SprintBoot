package com.example.dbapplication.Message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

@Configuration
public class MessageConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            MessageRepository repository){
        return args -> {
            Message accident0 = new Message(
                    "Paul",
                    "Saint st",
                    LocalDateTime.of(2021, JANUARY, 15, 3, 2),
                    2,
                    "L234OQ",
                    false

            );

            Message accident1 = new Message(
                    "Moria",
                    "Victory st",
                    LocalDateTime.of(2021, FEBRUARY, 21, 3, 9),
                    10,
                    "V893J0",
                    true

            );
            repository.saveAll(
                    List.of(accident1, accident0)
            );
        };
    }
}

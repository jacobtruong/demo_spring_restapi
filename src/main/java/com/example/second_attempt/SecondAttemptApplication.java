package com.example.second_attempt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecondAttemptApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondAttemptApplication.class, args);
    }

}

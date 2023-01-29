package com.eltmvl.board129;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Board129Application {

    public static void main(String[] args) {
        SpringApplication.run(Board129Application.class, args);
    }

}

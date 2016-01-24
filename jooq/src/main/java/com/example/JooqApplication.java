package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JooqApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==== helllooo ====");
    }
}

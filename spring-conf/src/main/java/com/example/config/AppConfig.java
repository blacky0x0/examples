package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DBConfig.class, JooqConfig.class })
@ComponentScan({ "com.example.service" })
public class AppConfig {

}

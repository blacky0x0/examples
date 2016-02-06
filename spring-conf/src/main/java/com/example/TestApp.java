package com.example;

import com.example.config.AppConfig;
import com.example.jdbc.JdbcExample;
import com.example.service.DataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {

    public static void main(final String[] args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        JdbcExample jdbcExample = ctx.getBean(JdbcExample.class);

        DataService dataService = ctx.getBean(DataService.class);

        dataService.showData();

        System.out.println(jdbcExample.getBook(1));
        System.out.println(jdbcExample.getAuthor(1));

        dataService.showDataJooq();
    }

}
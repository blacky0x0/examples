package com.example;

import com.example.jdbc.JdbcExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");

        JdbcExample jdbcExample = ctx.getBean(JdbcExample.class);
        System.out.println(jdbcExample.getBook(1));

    }

}
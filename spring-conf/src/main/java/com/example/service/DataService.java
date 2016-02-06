package com.example.service;

import com.example.jdbc.JdbcExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired JdbcExample jdbcExample;

    public void showData() {
        System.out.println(jdbcExample.getAuthor(1));
        System.out.println(jdbcExample.getBook(1));
    }

}

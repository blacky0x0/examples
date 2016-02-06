package com.example.service;

import com.example.entity.postgres.tables.daos.AuthorDao;
import com.example.jdbc.JdbcExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired JdbcExample jdbcExample;
    @Autowired AuthorDao authorDao;

    public void showData() {
        System.out.println(jdbcExample.getAuthor(1));
        System.out.println(jdbcExample.getBook(1));
    }

    public void showDataJooq() {
        System.out.println("===jooq-query===");
        System.out.println(authorDao.fetchOneById(1));
    }
}

package com.example.service;

import com.example.entity.postgres.tables.daos.AuthorDao;
import com.example.jdbc.JdbcExample;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.entity.postgres.Tables.AUTHOR;

@Service
public class DataService {

    @Autowired JdbcExample jdbcExample;
    @Autowired AuthorDao authorDao;
    @Autowired DSLContext dsl;

    public void showData() {
        System.out.println(jdbcExample.getAuthor(1));
        System.out.println(jdbcExample.getBook(1));
    }

    //@Transactional //-- could be replaced by dsl.transaction()
    public void showDataJooq() {
        System.out.println("===jooq-query===");
        System.out.println(authorDao.fetchOneById(1));

        // throws an exception
        dsl.transaction(c -> {
            dsl.insertInto(AUTHOR)
                    .set(AUTHOR.ID, 5)
                    .set(AUTHOR.NAME, "name")
                    .execute();

            dsl.insertInto(AUTHOR)
                    .set(AUTHOR.ID, 5)
                    .set(AUTHOR.NAME, "name")
                    .execute();
        });
    }
}

package com.example.model;

import com.example.config.RepositoryConfiguration;
import com.example.repository.AnotherBookRepository;
import com.example.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
//@SpringApplicationConfiguration(LowercaseApplication.class)
public class BookTest {

    @Autowired BookRepository bookRepository;
    @Autowired AnotherBookRepository anotherBookRepository;

    @Test
    public void lowerCaseEquality() throws Exception {
        //System.out.println(bookRepository.findAll());
        System.out.println(bookRepository.findOne(1));
        System.out.println(anotherBookRepository.findOne(2));
    }

}
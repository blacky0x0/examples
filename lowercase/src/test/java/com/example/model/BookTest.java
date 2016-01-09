package com.example.model;

import com.example.config.RepositoryConfiguration;
import com.example.repository.AnotherBookRepository;
import com.example.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
//@SpringApplicationConfiguration(LowercaseApplication.class)
public class BookTest {

    @Autowired BookRepository bookRepository;
    @Autowired AnotherBookRepository anotherBookRepository;

    @Test
    public void lowerCaseEquality() throws Exception {
        System.out.println("================================");
        System.out.println("================================");
        System.err.format("Maximum id value is: %s\n", bookRepository.maxId());

        int maxId = bookRepository.maxId();

        for (int i = 1; i <= maxId; i++) {
            Book item = bookRepository.findOne(i);
            AnotherBook item2 = anotherBookRepository.findOne(i);

            if (Objects.nonNull(item)) {
                if (!item.getTitle().equals(item2.getTitle())) {
                    System.err.format("ID: %d; `%s` != `%s`\n", item.getId(), item.getTitle(), item2.getTitle());
                }
            }
        }

        System.out.flush();
        System.out.println("================================");
        System.out.println("================================");
    }

}
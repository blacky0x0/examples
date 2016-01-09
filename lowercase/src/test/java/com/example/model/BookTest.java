package com.example.model;

import com.example.config.RepositoryConfiguration;
import com.example.repository.AnotherBookRepository;
import com.example.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;
import java.util.Objects;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
//@SpringApplicationConfiguration(LowercaseApplication.class)
public class BookTest {

    @Autowired BookRepository bookRepository;
    @Autowired AnotherBookRepository anotherBookRepository;

    @Test
    public void lowerCaseEquality() throws Exception {
        long maxId = bookRepository.maxId();

        System.out.println("================================");
        System.out.println("================================");
        System.err.format("Maximum id value is: %s\n", maxId);
        System.out.flush();

        for (int i = 1; i <= maxId; i++) {
            Thread.sleep(8);
            Book item = bookRepository.findOne(i);

            if (Objects.isNull(item))
                continue;

            if (i % 10000 == 0)
                System.out.println("> " + i);

            AnotherBook item2 = anotherBookRepository.findOne(i);

            if (!item.getTitle().toLowerCase(Locale.ENGLISH).equals(item2.getTitle())) {
                System.err.format("ID: %d; ::: `%s` ::: `%s` != `%s`\n",
                        item.getId(), item.getTitle().toLowerCase(Locale.ENGLISH),
                        item.getTitle(), item2.getTitle());
                System.out.flush();
            }

            item2 = null;
            item = null;
        }

        System.out.flush();
        System.out.println("================================");
        System.out.println("================================");
    }

}
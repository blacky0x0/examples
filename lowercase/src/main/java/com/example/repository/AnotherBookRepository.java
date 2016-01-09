package com.example.repository;

import com.example.model.AnotherBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnotherBookRepository extends JpaRepository<AnotherBook, Integer> {

    @Query(value = "SELECT max(id) as id FROM another_book", nativeQuery = true)
    Integer maxId();

}

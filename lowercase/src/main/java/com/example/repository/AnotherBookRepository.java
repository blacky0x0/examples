package com.example.repository;

import com.example.model.AnotherBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherBookRepository extends JpaRepository<AnotherBook, Integer> {

}

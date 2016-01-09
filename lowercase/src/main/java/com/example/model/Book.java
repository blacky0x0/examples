package com.example.model;

import lombok.*;
import javax.persistence.*;

@Entity (name = "book") @Setter @Getter @ToString
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

}

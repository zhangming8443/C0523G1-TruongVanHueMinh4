package com.example.book_application.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String borrowCode;
    private LocalDate borrowDate;
    private LocalDate returnDate;


}

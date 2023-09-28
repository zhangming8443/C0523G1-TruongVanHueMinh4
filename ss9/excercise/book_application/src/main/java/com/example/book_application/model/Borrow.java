package com.example.book_application.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int borrowId;
    @Column(name = "borrow_code")
    private int borrowCode;
    @Column(name = "borrow_date")
    private LocalDate borrowDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public Borrow() {
    }

    public Borrow(int borrowId, int borrowCode, LocalDate borrowDate, LocalDate returnDate, Book book) {
        this.borrowId = borrowId;
        this.borrowCode = borrowCode;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

package com.example.book.model;

import com.example.book.model.Book;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "borrow_code")
    private long borrowCode;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public Borrow() {
    }

    public Borrow(int id, long borrowCode, Book book) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(long borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

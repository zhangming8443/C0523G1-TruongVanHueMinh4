package com.example.book_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_quantity")
    private int bookQuantity;

    @Column(name = "book_image")
    private String bookImage;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Borrow> borrowList;
    @ManyToMany(mappedBy = "bookList")
    private List<Student> studentList;

    public Book() {
    }

    public Book(int bookId, String bookName, int bookQuantity, String bookImage, List<Borrow> borrowList, List<Student> studentList) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookImage = bookImage;
        this.borrowList = borrowList;
        this.studentList = studentList;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

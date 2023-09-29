package com.example.book_store.model;

import javax.persistence.*;
import java.io.StringReader;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private Integer bookId;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_price", nullable = false)
    private double bookPrice;

    @Column(name = "book_quantity", nullable = false)
    private int bookQuantity;

    @Column(name = "book_description", columnDefinition = "LONGTEXT")
    private String bookDescription;

    @Column(name = "book_image", nullable = false)
    private String bookImage;
    @Column(name = "book_discount")
    private short bookDiscount;

    public BookEntity() {
    }

    public BookEntity(Integer bookId, String bookName, double bookPrice, int bookQuantity, String bookDescription, String bookImage, short bookDiscount) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.bookDiscount = bookDiscount;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public short getBookDiscount() {
        return bookDiscount;
    }

    public void setBookDiscount(short bookDiscount) {
        this.bookDiscount = bookDiscount;
    }
}

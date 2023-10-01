package com.example.book_store.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;


public class BookDto {
    private Integer bookId;
    @NotNull
    private String bookName;
    @NotNull
    private double bookPrice;

    private int bookQuantity;

    private String bookDescription;
    @NotNull
    private String bookImage;
    private short bookDiscount;

    public BookDto() {
    }

    public BookDto(Integer bookId, String bookName, double bookPrice, int bookQuantity, String bookDescription, String bookImage, short bookDiscount) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.bookDiscount = bookDiscount;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto that = (BookDto) o;
        return bookId == that.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}

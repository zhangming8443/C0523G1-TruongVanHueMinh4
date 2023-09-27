package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    boolean borrow(Book book);
    Book findById(int id);
    void borrowBook(int idBook, long code);
    long generateBorrowCode();
    void saveBorrow(long code, Book book);


}

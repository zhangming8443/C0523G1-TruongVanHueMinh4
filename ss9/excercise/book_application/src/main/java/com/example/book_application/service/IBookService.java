package com.example.book_application.service;

import com.example.book_application.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> showBookList();
    Book findById(int bookId);

    boolean save(Book book);
}

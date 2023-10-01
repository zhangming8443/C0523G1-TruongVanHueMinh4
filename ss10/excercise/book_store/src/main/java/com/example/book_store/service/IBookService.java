package com.example.book_store.service;

import com.example.book_store.model.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> findAllBook();

    BookEntity findById(Integer idBook);
}

package com.example.book_store.service;

import com.example.book_store.model.BookEntity;
import com.example.book_store.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements  IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<BookEntity> findAllBook() {
        return bookRepository.findAll();
    }

}

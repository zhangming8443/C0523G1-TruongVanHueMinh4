package com.example.book_application.service;

import com.example.book_application.model.Book;
import com.example.book_application.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> showBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public boolean save(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

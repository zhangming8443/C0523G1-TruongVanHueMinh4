package com.example.book_application.service;

import com.example.book_application.model.Book;
import com.example.book_application.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBorrowService {
    void saveBorrowCode(int borrowCode, Book book);
    List<Borrow> findAll();
    boolean removeBorrowCode(int borrowId);
    Borrow findByCode(int borrowCode);
}

package com.example.book_application.repository;

import com.example.book_application.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByBookNameContaining(Pageable pageable, String bookName);
}

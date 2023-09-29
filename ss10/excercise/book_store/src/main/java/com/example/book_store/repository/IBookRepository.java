package com.example.book_store.repository;

import com.example.book_store.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<BookEntity, Integer> {
}

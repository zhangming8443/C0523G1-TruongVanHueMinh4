package com.example.book_application.repository;

import com.example.book_application.model.Book;
import com.example.book_application.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
}

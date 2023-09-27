package com.example.book.repository;

import com.example.book.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepo extends JpaRepository<Borrow,Integer> {
}

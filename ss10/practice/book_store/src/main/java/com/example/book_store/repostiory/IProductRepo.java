package com.example.book_store.repostiory;

import com.example.book_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepo extends JpaRepository<Product, Integer> {
}

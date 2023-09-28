package com.example.book_store.service;

import com.example.book_store.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
}

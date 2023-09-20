package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean add(Product product);

    Product findById(int id);

    boolean update(int id, Product product);

    boolean remove(int id);
    List<Product> findByName(String name);


}

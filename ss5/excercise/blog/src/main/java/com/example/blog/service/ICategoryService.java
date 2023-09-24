package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean create(Category category);
    Category findByiD(int id);
    boolean update(Category category);
    boolean delete(int id);
}

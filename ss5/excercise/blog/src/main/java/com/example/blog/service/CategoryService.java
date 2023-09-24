package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean create(Category category) {
        Category newCategory = categoryRepository.save(category);
        return newCategory != null;
    }

    @Override
    public Category findByiD(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean update(Category category) {
        if (findByiD(category.getIdCategory()) == null) {
            return false;
        } else {
            categoryRepository.save(category);
            return true;
        }
    }

    @Override
    public boolean delete(int id) {
        categoryRepository.deleteById(id);
        return true;
    }
}

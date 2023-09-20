package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepo.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public boolean update(int id, Product product) {
        return productRepo.update(id,product);
    }

    @Override
    public boolean remove(int id) {
        return productRepo.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName("%"+name+"%");
    }
}

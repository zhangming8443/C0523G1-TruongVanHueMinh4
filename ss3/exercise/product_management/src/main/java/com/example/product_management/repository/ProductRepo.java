package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo implements IProductRepo {
    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Iphone 14 Pro Max", 500, "Iphone"));
        productList.put(2, new Product(2, "Iphone 15 Pro Max", 600, "Iphone"));
        productList.put(3, new Product(3, "Iphone 11 Pro Max", 700, "Iphone"));
        productList.put(4, new Product(4, "Iphone 12 Pro Max", 333, "Iphone"));
        productList.put(5, new Product(5, "Iphone 13 Pro Max", 222, "Iphone"));
        productList.put(6, new Product(6, "Iphone XS Max", 111, "Iphone"));
        productList.put(7, new Product(7, "Iphone X", 444, "Iphone"));
        productList.put(8, new Product(8, "Iphone XR", 321, "Iphone"));
        productList.put(9, new Product(9, "Xiaomi Pad 6", 341, "Xiaomi"));
        productList.put(10, new Product(10, "Samsung Flip 4", 753, "Samsung"));
        productList.put(11, new Product(11, "Samsung S22 Ultra", 757, "Samsung"));
        productList.put(12, new Product(12, "Samsung Flip 3", 532, "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return productList.get(name);
    }
}

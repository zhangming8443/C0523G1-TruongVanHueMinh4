package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception ignored) {
            System.out.println("Fail");
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean update(int id, Product product) {
        try {
            Product productToUpdate = findById(id);
            if (productToUpdate == null) {
                System.out.println("Product not found");
                return false;
            }
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setBrand(product.getBrand());

            entityManager.merge(productToUpdate);
        } catch (Exception ignored) {
            System.out.println("Fail");
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public boolean remove(int id) {
        try {
            Product product = findById(id);
            if (product == null) {
                System.out.println("Product not found");
                return false;
            }
            entityManager.remove(product);
        } catch (Exception exception) {
            System.out.println("Fail");
            return false;
        }
        return true;
    }

    @Override
    public List<Product> findByName(String name) {
//        List<Product> productSearch = new ArrayList<>();
//        List<Product> productList = findAll();
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getName().contains(name)) {
//                productSearch.add(productList.get(i));
//            }
//        }
//        return productSearch;
        TypedQuery<Product> query = entityManager.createQuery("from Product where name like :name ", Product.class);
        query.setParameter("name",name);
        return query.getResultList();
    }
}

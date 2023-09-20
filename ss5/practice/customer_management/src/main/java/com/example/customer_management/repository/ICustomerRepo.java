package com.example.customer_management.repository;

import com.example.customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();
    boolean add(Customer customer);
    Customer findById(int id);
}

package com.example.customer_management_thymeleaf.service;

import com.example.customer_management_thymeleaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}

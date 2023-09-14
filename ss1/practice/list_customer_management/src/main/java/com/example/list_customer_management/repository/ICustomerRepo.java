package com.example.list_customer_management.repository;

import com.example.list_customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();
    void add(Customer customer);
}

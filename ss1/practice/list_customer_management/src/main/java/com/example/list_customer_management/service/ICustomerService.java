package com.example.list_customer_management.service;

import com.example.list_customer_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void add(Customer customer);
}

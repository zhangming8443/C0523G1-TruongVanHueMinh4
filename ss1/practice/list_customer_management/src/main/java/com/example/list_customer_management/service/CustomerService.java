package com.example.list_customer_management.service;

import com.example.list_customer_management.model.Customer;
import com.example.list_customer_management.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private final ICustomerRepo customerRepo;

    public CustomerService(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepo.add(customer);
    }
}

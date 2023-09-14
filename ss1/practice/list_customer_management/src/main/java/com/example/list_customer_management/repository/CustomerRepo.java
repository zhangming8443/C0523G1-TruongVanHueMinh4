package com.example.list_customer_management.repository;

import com.example.list_customer_management.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepo implements ICustomerRepo {
    private static final List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Nguyen Van A", "a@gmail.com", "Ha Noi"));
        customerList.add(new Customer(2,"Nguyen Van B", "b@gmail.com", "Ha Tinh"));
        customerList.add(new Customer(3,"Nguyen Van C", "c@gmail.com", "Ha Giang"));
        customerList.add(new Customer(4,"Nguyen Van D", "d@gmail.com", "Sa Pa"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }
}

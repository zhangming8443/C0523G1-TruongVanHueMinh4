package com.example.customer_management.repository;

import com.example.customer_management.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo{
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Nguyen A", "dahd@gmail.com", "haahahah"));
        customerList.add(new Customer(2,"Nguyen Z", "dahd@gmail.com", "dsdsdsds"));
        customerList.add(new Customer(3,"Nguyen S", "dahd@gmail.com", "dsdsdaaaaa"));
        customerList.add(new Customer(4,"Nguyen E", "dahd@gmail.com", "vcvcvc"));
        customerList.add(new Customer(5,"Nguyen H", "dahd@gmail.com", "sdsd"));
        customerList.add(new Customer(6,"Nguyen B", "dahd@gmail.com", "adscqfq"));
        customerList.add(new Customer(7,"Nguyen X", "dahd@gmail.com", "dfsdfdsgr"));
        customerList.add(new Customer(8,"Nguyen C", "dahd@gmail.com", "rtrtrwe"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void create(Customer customer) {

    }
}

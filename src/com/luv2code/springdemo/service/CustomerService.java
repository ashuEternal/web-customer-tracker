package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustome(int id);
}

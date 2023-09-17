package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.Customer;
import com.assignment.project.hotelreservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
        Customer Services
 */

@Service
public class CustomerServices {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customer= new ArrayList<>();
        customerRepository.findAll().forEach(customer::add);
        return customer;
    }

    public Customer getCustomer(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(String id, Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
    
}

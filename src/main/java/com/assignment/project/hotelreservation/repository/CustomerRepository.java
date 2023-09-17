package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/*
        Customer Repository
 */

public interface CustomerRepository extends JpaRepository<Customer,String> {
    
}

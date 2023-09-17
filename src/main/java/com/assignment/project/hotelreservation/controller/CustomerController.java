package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.Customer;
import com.assignment.project.hotelreservation.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Customer Controller
 */

@RestController
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerServices.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerServices.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/customers")
    public void addCustomer(@RequestBody Customer customer){
       customerServices.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String id){
       customerServices.updateCustomer(id,customer);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/customers/{id}")
    public void deleteCustomer(@PathVariable String id){
        try {
            customerServices.deleteCustomer(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this customer", e);
        }
    }
}

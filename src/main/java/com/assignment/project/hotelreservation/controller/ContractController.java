package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.Contract;
import com.assignment.project.hotelreservation.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Contract Controller
 */

@RestController
@CrossOrigin(origins = "*")
public class ContractController {
    @Autowired
    private ContractServices contractServices;

    @RequestMapping("/contracts")
    public List<Contract> getAllContract(){
        return contractServices.getAllContracts();
    }

    @RequestMapping("/contracts/{id}")
    public Contract getContract(@PathVariable String id){
        return contractServices.getContract(id);
    }

    @RequestMapping("/hotels/{hotelId}/contracts")
    public List<Contract> getContractByHotelId(@PathVariable String hotelId){
        return contractServices.getContractByHotelId(hotelId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/hotels/{hotelId}/contracts")
    public void addContract(@RequestBody Contract contract, @PathVariable String hotelId){
        contractServices.addContract(contract,hotelId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/hotels/{hotelId}/contracts")
    public void updateContract(@RequestBody Contract contract, @PathVariable String hotelId){
        contractServices.updateContract(hotelId,contract);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/contracts/{id}")
    public void deleteContract(@PathVariable String id){
        try {
            contractServices.deleteContract(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this contract", e);
        }
    }
}

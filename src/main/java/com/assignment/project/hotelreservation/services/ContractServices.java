package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.Contract;
import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
        Contract Services
 */

@Service
public class ContractServices {
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        List<Contract> contracts= new ArrayList<>();
        contractRepository.findAll().forEach(contracts::add);
        return contracts;
    }

    public Contract getContract(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Contract addContract(Contract contracts, String hotelId) {
        Hotel hotel=new Hotel(hotelId,"","");
        contracts.setHotel(hotel);
       return contractRepository.save(contracts);
    }

    public Contract updateContract(String hotelId, Contract contracts) {
        Hotel hotel=new Hotel(hotelId,"","");
        contracts.setHotel(hotel);
        return contractRepository.save(contracts);
    }

    public void deleteContract(String id) {
        contractRepository.deleteById(id);
    }

    public List<Contract> getContractByHotelId(String hotelId) {
        List<Contract> contracts= new ArrayList<>();
        contractRepository.findByHotelId(hotelId).forEach(contracts::add);
        return contracts;
    }

}

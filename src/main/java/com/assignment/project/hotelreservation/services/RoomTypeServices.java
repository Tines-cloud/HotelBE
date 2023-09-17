package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.Contract;
import com.assignment.project.hotelreservation.model.RoomType;
import com.assignment.project.hotelreservation.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.Date;

/*
        Room Type Services
 */

@Service
public class RoomTypeServices {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    public List<RoomType> getAllRoomTypes() {
        List<RoomType> roomType= new ArrayList<>();
        roomTypeRepository.findAll().forEach(roomType::add);
        return roomType;
    }

    public RoomType getRoomType(String id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    public RoomType addRoomType(String contractId, RoomType roomType) {
        Date fromDate= new Date(2022,05,24);
        Date toDate=new Date(2022,05,24);
        Contract contract=new Contract(contractId,fromDate,toDate,0);
        roomType.setContract(contract);
        return roomTypeRepository.save(roomType);
    }
    public RoomType updateRoomType(String contractId, RoomType roomType) {
        Date fromDate= new Date(2022,05,24);
        Date toDate=new Date(2022,05,24);
        Contract contract=new Contract(contractId,fromDate,toDate,0);
        roomType.setContract(contract);
        return roomTypeRepository.save(roomType);
    }
    public void deleteRoomType(String id) {
        roomTypeRepository.deleteById(id);
    }


    public List<RoomType> getRoomTypeByContractId(String contractId) {
       return roomTypeRepository.findByContractId(contractId);
    }
}

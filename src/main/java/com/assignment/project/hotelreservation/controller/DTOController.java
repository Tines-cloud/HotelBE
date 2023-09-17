package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.DTO.HotelRooms;
import com.assignment.project.hotelreservation.services.HotelRoomDTOServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/*
        Hotel Room Search Controller
 */

@RestController
@CrossOrigin(origins = "*")
public class DTOController {

    @Autowired
    private HotelRoomDTOServices hotelRoomDTOServices;

    @RequestMapping("/resultFinal/{date}/{noOfDays}/{roomCount}/{adultCount}")
    public List<HotelRooms> getResults(@PathVariable Date date, @PathVariable int noOfDays, @PathVariable int roomCount, @PathVariable int adultCount){
        return hotelRoomDTOServices.getOutputDetails(date,noOfDays,roomCount,adultCount);
    }
}

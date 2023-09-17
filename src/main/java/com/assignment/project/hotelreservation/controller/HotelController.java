package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Hotel Controller
 */

@RestController
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @RequestMapping("/hotels")
    public List<Hotel> getAllHotel(){
        return hotelServices.getAllHotels();
    }

    @RequestMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable String id){
        return hotelServices.getHotel(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/hotels")
    public void addHotel(@RequestBody Hotel hotel){
        hotelServices.addHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/hotels/{id}")
    public void updateHotel(@RequestBody Hotel hotel, @PathVariable String id){
        hotelServices.updateHotel(id,hotel);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/hotels/{id}")
    public void deleteHotel(@PathVariable String id){
        try {
            hotelServices.deleteHotel(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this hotel", e);
        }
    }
}

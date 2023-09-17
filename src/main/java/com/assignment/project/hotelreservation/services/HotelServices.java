package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
        Hotel Services
 */

@Service
public class HotelServices {

    @Autowired
    private HotelRepository hotelRepository;
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels=new ArrayList<>();
        hotelRepository.findAll().forEach(hotels::add);
        return hotels;
    }

    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(String id, Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }

}

package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/*
        Hotel Repository
 */

public interface HotelRepository extends JpaRepository<Hotel,String> {

}

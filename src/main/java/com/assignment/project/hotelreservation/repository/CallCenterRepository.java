package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.CallCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/*
        Agent Repository
 */

public interface CallCenterRepository extends JpaRepository<CallCenter,String> {
    
}

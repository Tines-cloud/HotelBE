package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

/*
        Agent Repository
 */

public interface AgentRepository extends JpaRepository<Agent,String> {
    
}

package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
        Contract Repository
 */

public interface ContractRepository extends JpaRepository<Contract,String> {
    List<Contract> findByHotelId(String hotelId);

}

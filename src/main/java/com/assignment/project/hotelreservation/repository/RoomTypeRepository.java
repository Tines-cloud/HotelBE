package com.assignment.project.hotelreservation.repository;

import com.assignment.project.hotelreservation.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Set;


/*
        Room Type Repository
 */

public interface RoomTypeRepository extends JpaRepository<RoomType,String> {
    List<RoomType> findByContractId(String ContractId);

/*
        select room types from inner joined Hotel,Contract,Room Types tables
        where the Check in and Check out dates are between the contract period
        and where the available room count is grater than equal to the required room count
 */

    @Query("select r from RoomType r INNER JOIN Contract c on c.id=r.contract.id " +
            "Inner JOIN Hotel h on h.id=c.hotel.id "+
            "WHERE (c.fromDate <= ?1 and c.toDate>=?1) " +
            "and (c.fromDate <= ?2 and c.toDate>=?2) " +
            "and ((r.totalRooms-r.reservedRooms)>=?3)")
    Set<RoomType> getHotelsAndRooms(Date CheckInDate, Date CheckOutDate , int roomCount);
}

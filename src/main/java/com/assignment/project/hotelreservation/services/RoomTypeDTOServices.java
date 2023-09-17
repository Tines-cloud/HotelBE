package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.DTO.RoomTypes;
import com.assignment.project.hotelreservation.model.RoomType;
import com.assignment.project.hotelreservation.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
        Room Type DTO Services
 */

@Service
public class RoomTypeDTOServices {

    /*
            declared the variable to assign no of nights
            declared the variable to assign no of Adults
     */
    private int noOfNights;
    private int noOfAdults;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    /*
            store room types to the list and return the list
     */
    public List<RoomTypes> getAllDetails(Date date, int noOfDays, int roomCount, int adultCount){
        noOfNights=noOfDays;
        noOfAdults=adultCount;

        Date date2=AddDateService.addDate(date,noOfDays);

        List<RoomTypes> roomTypes =roomTypeRepository.getHotelsAndRooms(date,date2,roomCount).stream().map(this::convertEntityToDto).collect(Collectors.toList());

        return roomTypes;
    }

    /*
            convert room type entity to a room types dto
     */

    private RoomTypes convertEntityToDto(RoomType roomType){
        RoomTypes roomDTO = new RoomTypes();
        roomDTO.setContractId(roomType.getContract().getId());
        roomDTO.setHotelId(roomType.getContract().getHotel().getId());
        roomDTO.setRoomType(roomType.getName());
        double markup=roomType.getContract().getMarkup();
        roomDTO.setTotalCost(((int)((roomType.getPricePerAdult()*((markup+100)/100)*noOfAdults*noOfNights)*100))/100.0);
        return roomDTO;
    }
}

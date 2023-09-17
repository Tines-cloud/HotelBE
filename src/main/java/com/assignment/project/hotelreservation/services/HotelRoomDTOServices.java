package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.DTO.HotelRooms;
import com.assignment.project.hotelreservation.DTO.RoomTypes;
import com.assignment.project.hotelreservation.model.RoomType;
import com.assignment.project.hotelreservation.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
       Hotel Room DTO Services
 */
@Service
public class HotelRoomDTOServices {

    /*
            created a list store Hotel Ids
            this for find duplications of hotel ids
            this is used to retrieve room types and contracts of one hotel
     */
    List<String> list=new ArrayList<>();

    /*
            created variables to store check in date, no of days, required room count, adult count
     */
    Date date;
    int noOfDays;
    int roomCount;
    int adultCount;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomTypeDTOServices roomTypeDTOServices;

    /*
            store room types to the list and return the list
     */

    public List<HotelRooms> getAllDetails(Date checkInDate, int noOfDays, int roomCount, int adultCount){
        this.date = checkInDate;
        this.noOfDays=noOfDays;
        this.adultCount=adultCount;
        this.roomCount=roomCount;

        Date checkOutDate=AddDateService.addDate(checkInDate,noOfDays);

        List<HotelRooms> hotelRooms=roomTypeRepository.getHotelsAndRooms(checkInDate,checkOutDate,roomCount).stream().map(this::convertEntityToDto).collect(Collectors.toList());
       /*
            after retrieving list of hotels clear the stored list of hotel ids
        */
        list.clear();
        return  hotelRooms;
    }

    /*
            convert room type entity to a hotel room type dto
     */

    private HotelRooms convertEntityToDto(RoomType roomType){
        HotelRooms hotelRooms = new HotelRooms();
            if(!list.contains(roomType.getContract().getHotel().getId())) {
                hotelRooms.setHotelId(roomType.getContract().getHotel().getId());
                hotelRooms.setHotelName(roomType.getContract().getHotel().getName());
                hotelRooms.setLocation(roomType.getContract().getHotel().getLocation());

                String hotelId = roomType.getContract().getHotel().getId();

                /*
                        store room type dto in list
                 */
                List<RoomTypes> roomTypes = roomTypeDTOServices.getAllDetails(date, noOfDays, roomCount, adultCount);

                /*
                        create new room type dto list
                 */
                List<RoomTypes> roomDTOs = new ArrayList<>();

                /*
                        looped room types and added room types dto to an array list
                 */
                for (RoomTypes roomDTO : roomTypes) {
                    if (roomDTO.getHotelId().equals(hotelId)) {
                        roomDTOs.add(roomDTO);
                    }
                }
                /*
                        setRoom details in hotel room dto
                 */
                hotelRooms.setRoomDetails(roomDTOs);

                /*
                        add hotel room id after storing all detail room types
                 */
                list.add(roomType.getContract().getHotel().getId());
            }
            else{
                /*
                        for duplicated hotels hotel rooms dto set as null
                 */
                hotelRooms =null;
            }

        return hotelRooms;
    }

    public List<HotelRooms> getOutputDetails(Date date, int noOfDays, int roomCount, int adultCount){
        List<HotelRooms> hotelRooms=new ArrayList<>(getAllDetails(date,noOfDays,roomCount,adultCount));

        /*
                remove null hotel rooms
         */
       while(hotelRooms.remove(null)){
        }

        return hotelRooms;
    }
}

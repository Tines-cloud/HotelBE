package com.assignment.project.hotelreservation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/*
            Hotel Room Search DTO
 */

public class HotelRooms {
    @JsonIgnore
    private String hotelId;
    private String hotelName;
    private String location;
    private List<RoomTypes> roomDetails;

    public HotelRooms() {
    }

    public HotelRooms(String hotelId, String hotelName, String location, List<RoomTypes> roomDetails) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.roomDetails = roomDetails;
    }

    public HotelRooms(String hotelName, String location, List<RoomTypes> roomDetails) {
        this.hotelName = hotelName;
        this.location = location;
        this.roomDetails = roomDetails;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<RoomTypes> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomTypes> roomDetails) {
        this.roomDetails = roomDetails;
    }
}

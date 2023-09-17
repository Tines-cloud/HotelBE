package com.assignment.project.hotelreservation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
        Room Type DTO
 */

public class RoomTypes {
    @JsonIgnore
    private String contractId;
    @JsonIgnore
    private String hotelId;
    private String roomType;
    private double totalCost;

    public RoomTypes() {
    }

    public RoomTypes(String contractId, String hotelId, String roomType, double totalCost) {
        this.contractId = contractId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.totalCost = totalCost;
    }

    public RoomTypes(String roomType, double totalCost) {
        this.roomType = roomType;
        this.totalCost = totalCost;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}



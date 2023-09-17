package com.assignment.project.hotelreservation.model;

import javax.persistence.*;

/*
        Room Type Model
 */

@Entity
@Table(name = "E1520_RoomType")
public class RoomType {
    @Id
    private String id;
    private String name;
    private double pricePerAdult;
    private int maxAdult;
    private int totalRooms;
    private int reservedRooms;
   @ManyToOne
   @JoinColumn(name = "contract_id")
   private Contract contract;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public RoomType() {
    }

    public RoomType(String id, String name, double pricePerAdult, int maxAdult, int totalRooms, int reservedRooms, Contract contract) {
        this.id = id;
        this.name = name;
        this.pricePerAdult = pricePerAdult;
        this.maxAdult = maxAdult;
        this.totalRooms = totalRooms;
        this.reservedRooms = reservedRooms;
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(double pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    public int getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(int maxAdult) {
        this.maxAdult = maxAdult;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getReservedRooms() {
        return reservedRooms;
    }

    public void setReservedRooms(int reservedRooms) {
        this.reservedRooms = reservedRooms;
    }

}

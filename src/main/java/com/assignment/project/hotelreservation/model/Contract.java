package com.assignment.project.hotelreservation.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/*
        Contract Model
 */

@Entity
@Table(name = "E1520_Contract")
public class Contract {
    @Id
    private String id;
    private Date fromDate;
    private Date toDate;
    private double markup;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "contract")
    private List<RoomType> roomTypes;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Contract() {
    }

    public Contract(String id, Date fromDate, Date toDate, double markup, Hotel hotel) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.markup = markup;
        this.hotel = hotel;
    }

    public Contract(String id, Date fromDate, Date toDate, double markup) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.markup = markup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }
}

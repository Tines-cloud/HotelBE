package com.assignment.project.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/*
        Hotel Model
 */

@Entity
@Table(name = "E1520_Hotel")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<Contract> contracts;

    public Hotel() {
    }

    public Hotel(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

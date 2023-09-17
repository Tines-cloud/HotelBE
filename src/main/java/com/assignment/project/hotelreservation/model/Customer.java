package com.assignment.project.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
        Customer Model
 */

@Entity
@Table(name = "E1520_Customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private long mobile;

    public Customer() {
    }

    public Customer(String id, String name, String email, long mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}

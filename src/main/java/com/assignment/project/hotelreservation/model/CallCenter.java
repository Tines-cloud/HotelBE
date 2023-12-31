package com.assignment.project.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
        Call Center Model
 */

@Entity
@Table(name = "E1520_CallCenter")
public class CallCenter {
    @Id
    private String id;
    private String name;

    public CallCenter() {

    }

    public CallCenter(String id, String name) {
        this.id = id;
        this.name = name;
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
}

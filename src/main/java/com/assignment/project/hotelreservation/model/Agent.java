package com.assignment.project.hotelreservation.model;

import javax.persistence.*;

/*
        Agent Model
 */

@Entity
@Table(name = "E1520_Agent")
public class Agent {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "call_center_id")
    private CallCenter callCenter;

    public CallCenter getCallCenter() {
        return callCenter;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public Agent() {

    }

    public Agent(String id, String name) {
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

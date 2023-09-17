package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.CallCenter;
import com.assignment.project.hotelreservation.repository.CallCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
        Call Center Services
 */

@Service
public class CallCenterServices {
    @Autowired
    private CallCenterRepository callCenterRepository;

    public List<CallCenter> getAllCallCenters() {
        List<CallCenter> callCenters= new ArrayList<>();
        callCenterRepository.findAll().forEach(callCenters::add);
        return callCenters;
    }

    public CallCenter getCallCenter(String id) {
        return callCenterRepository.findById(id).orElse(null);
    }

    public void addCallCenter(CallCenter callCenter) {
        callCenterRepository.save(callCenter);
    }

    public void updateCallCenter(String id, CallCenter callCenter) {
        callCenterRepository.save(callCenter);
    }

    public void deleteCallCenter(String id) {
        callCenterRepository.deleteById(id);
    }
}

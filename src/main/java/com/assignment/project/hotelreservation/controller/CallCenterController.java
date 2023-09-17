package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.CallCenter;
import com.assignment.project.hotelreservation.services.CallCenterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Call Center Controller
 */
@RestController
public class CallCenterController {
    @Autowired
    private CallCenterServices callCenterServices;

    @RequestMapping("/callCenters")
    public List<CallCenter> getAllCallCenter(){
       return callCenterServices.getAllCallCenters();
    }

    @RequestMapping("/callCenters/{id}")
    public CallCenter getCallCenter(@PathVariable String id){
        return callCenterServices.getCallCenter(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/callCenters")
    public void addCallCenter(@RequestBody CallCenter callCenter){
        callCenterServices.addCallCenter(callCenter);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/callCenters/{id}")
    public void updateCallCenter(@PathVariable String id,@RequestBody CallCenter callCenter){
        callCenterServices.updateCallCenter(id,callCenter);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/callCenters/{id}")
    public void deleteCallCenter(@PathVariable String id){
        try {
            callCenterServices.deleteCallCenter(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this Call Center", e);
        }
    }
}

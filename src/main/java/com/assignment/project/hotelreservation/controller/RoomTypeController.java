package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.RoomType;
import com.assignment.project.hotelreservation.services.RoomTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Room Type Controller
 */

@RestController
@CrossOrigin(origins = "*")
public class RoomTypeController {
    @Autowired
    private RoomTypeServices roomTypeServices;

    @RequestMapping("/roomTypes")
    public List<RoomType> getAllRoomType(){
        return roomTypeServices.getAllRoomTypes();
    }

    @RequestMapping("/roomTypes/{id}")
    public RoomType getRoomType(@PathVariable String id){
        return roomTypeServices.getRoomType(id);
    }

    @RequestMapping("/contracts/{contractId}/roomTypes")
    public List<RoomType> getRoomTypeByContractId(@PathVariable String contractId){
        return roomTypeServices.getRoomTypeByContractId(contractId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/contracts/{contractId}/roomTypes")
    public void addRoomType(@RequestBody RoomType roomType, @PathVariable String contractId){
       roomTypeServices.addRoomType(contractId,roomType);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/contracts/{contractId}/roomTypes")
    public void updateRoomType(@RequestBody RoomType roomType, @PathVariable String contractId){
       roomTypeServices.updateRoomType(contractId,roomType);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/roomTypes/{id}")
    public void deleteRoomType(@PathVariable String id){
        try {
            roomTypeServices.deleteRoomType(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this room type", e);
        }
    }
}

package com.assignment.project.hotelreservation.controller;

import com.assignment.project.hotelreservation.model.Agent;
import com.assignment.project.hotelreservation.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
        Agent Controller
 */

@RestController
public class AgentController {
    @Autowired
    private AgentServices agentServices;

    @RequestMapping("/agents")
    public List<Agent> getAllAgent(){
        return agentServices.getAllAgent();
    }

    @RequestMapping("/agents/{id}")
    public Agent getAgent(@PathVariable String id){
        return agentServices.getAgent(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/agents")
    public void addAgent(@RequestBody Agent agent){
       agentServices.addAgent(agent);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/agents/{id}")
    public void updateAgent(@RequestBody Agent agent, @PathVariable String id){
       agentServices.updateAgent(id,agent);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/agents/{id}")
    public void deleteAgent(@PathVariable String id){
        try {
            agentServices.deleteAgent(id);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "can't delete this Agent", e);
        }
    }
}

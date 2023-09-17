package com.assignment.project.hotelreservation.services;

import com.assignment.project.hotelreservation.model.Agent;
import com.assignment.project.hotelreservation.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
        Agent Services
 */

@Service
public class AgentServices {
    @Autowired
    private AgentRepository agentRepository;
    public List<Agent> getAllAgent() {
        List<Agent> agent= new ArrayList<>();
        agentRepository.findAll().forEach(agent::add);
        return agent;
    }

    public Agent getAgent(String id) {
        return agentRepository.findById(id).orElse(null);
    }

    public void addAgent(Agent agent) {
        agentRepository.save(agent);
    }

    public void updateAgent(String id, Agent agent) {
        agentRepository.save(agent);
    }

    public void deleteAgent(String id) {
        agentRepository.deleteById(id);
    }
}

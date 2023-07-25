package com.example.elasticsearchsuggestivesearch.service;

import com.example.elasticsearchsuggestivesearch.domain.elasticsearch.Vehicle;
import com.example.elasticsearchsuggestivesearch.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    TaskRepository taskESRepository;

    public void saveVehicle(Vehicle vehicle){
        taskESRepository.save(vehicle);
    }

    public Vehicle getVehicleById(String id){
        return taskESRepository.findById(id).orElse(null);
    }

    public List<Vehicle> getLps(String lp){
        return taskESRepository.autoCompleteVehicleLpNaiveApproach(lp);
    }
}

package com.example.elasticsearchsuggestivesearch.controller;

import com.example.elasticsearchsuggestivesearch.domain.elasticsearch.Vehicle;
import com.example.elasticsearchsuggestivesearch.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public void saveVehicle(@RequestBody final Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
    }

    @GetMapping("/{vehicleId}")
    public List<Vehicle> getVehicleById(@PathVariable String vehicleId){
        return vehicleService.getLps(vehicleId);
    }


}

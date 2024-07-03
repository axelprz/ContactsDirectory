package com.axelprz.contactsdirectory.controller;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.City;
import com.axelprz.contactsdirectory.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id) {
        try{
            City city = cityService.getCityById(id);
            return ResponseEntity.ok(city);
        }catch(ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Integer id, @RequestBody City cityDetails) {
        try{
            City city = cityService.updateCity(id, cityDetails);
            return ResponseEntity.ok(city);
        }catch(ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable Integer id) {
        cityService.deleteCity(id);
    }
}

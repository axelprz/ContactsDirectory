package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Address;
import com.axelprz.contactsdirectory.model.City;
import com.axelprz.contactsdirectory.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private ICityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(Integer id) {
        Optional<City> optionalCity  = cityRepository.findById(id);
        return optionalCity.orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));
    }

    public City updateCity(Integer id, City cityDetails) {
        City city = getCityById(id);

        city.setName(cityDetails.getName());
        city.setState(cityDetails.getState());

        return cityRepository.save(city);
    }

    public void deleteCity(Integer id) {
        City city = getCityById(id);
        cityRepository.delete(city);
    }
}

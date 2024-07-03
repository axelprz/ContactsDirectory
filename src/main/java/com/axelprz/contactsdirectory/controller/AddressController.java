package com.axelprz.contactsdirectory.controller;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Address;
import com.axelprz.contactsdirectory.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
        try{
            Address address = addressService.getAddressById(id);
            return ResponseEntity.ok(address);
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Integer id, @RequestBody Address addressDetails) {
        try{
            Address address = addressService.updateAddress(id, addressDetails);
            return ResponseEntity.ok(address);
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}

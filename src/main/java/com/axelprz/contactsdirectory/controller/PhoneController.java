package com.axelprz.contactsdirectory.controller;

import com.axelprz.contactsdirectory.model.Phone;
import com.axelprz.contactsdirectory.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneService.createPhone(phone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Integer id) {
        try{
            Phone phone = phoneService.getPhoneById(id);
            return ResponseEntity.ok(phone);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Integer id, @RequestBody Phone phoneDetails) {
        try{
            Phone phone = phoneService.updatePhone(id, phoneDetails);
            return ResponseEntity.ok(phone);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhone(@PathVariable Integer id) {
        phoneService.deletePhone(id);
    }
}

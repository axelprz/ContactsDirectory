package com.axelprz.contactsdirectory.controller;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.State;
import com.axelprz.contactsdirectory.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State createState(@RequestBody State state) {
        return stateService.createState(state);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Integer id) {
        try{
            State state = stateService.getStateById(id);
            return ResponseEntity.ok(state);
        }catch(ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable Integer id, @RequestBody State stateDetails) {
        try{
            State state = stateService.updateState(id, stateDetails);
            return ResponseEntity.ok(state);
        }catch(ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteState(@PathVariable Integer id) {
        stateService.deleteState(id);
    }
}

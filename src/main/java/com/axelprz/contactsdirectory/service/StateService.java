package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.State;
import com.axelprz.contactsdirectory.repository.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private IStateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public State createState(State state) {
        return stateRepository.save(state);
    }

    public State getStateById(Integer id) {
        Optional<State> optionalState = stateRepository.findById(id);
        return optionalState.orElseThrow(() -> new ResourceNotFoundException("State not found with id " + id));
    }

    public State updateState(Integer id, State stateDetails) {
        State state = getStateById(id);

        state.setName(stateDetails.getName());
        state.setCities(stateDetails.getCities());

        return stateRepository.save(state);
    }

    public void deleteState(Integer id) {
        State state = getStateById(id);
        stateRepository.delete(state);
    }
}

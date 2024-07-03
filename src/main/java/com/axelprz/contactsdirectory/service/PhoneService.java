package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Phone;
import com.axelprz.contactsdirectory.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    IPhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone getPhoneById(Integer id) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        return optionalPhone.orElseThrow(() -> new ResourceNotFoundException("Phone not found with id " + id));
    }

    public Phone updatePhone(Integer id, Phone phoneDetails) {
        Phone phone = getPhoneById(id);

        phone.setNumber(phoneDetails.getNumber());
        phone.setType(phoneDetails.getType());

        return phoneRepository.save(phone);
    }

    public void deletePhone(Integer id) {
        Phone phone = getPhoneById(id);
        phoneRepository.delete(phone);
    }
}

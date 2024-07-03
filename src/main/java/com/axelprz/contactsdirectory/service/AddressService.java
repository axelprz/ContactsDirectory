package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Address;
import com.axelprz.contactsdirectory.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private IAddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer id) {
        Optional<Address> optionalAddress  = addressRepository.findById(id);
        return optionalAddress.orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
    }

    public Address updateAddress(Integer id, Address addressDetails) {
        Address address = getAddressById(id);

        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());

        return addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Address address = getAddressById(id);
        addressRepository.delete(address);
    }
}

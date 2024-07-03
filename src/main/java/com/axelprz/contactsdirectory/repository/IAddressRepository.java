package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
}

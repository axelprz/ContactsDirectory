package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}

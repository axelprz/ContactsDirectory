package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer> {
}

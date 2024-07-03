package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, Integer> {
}

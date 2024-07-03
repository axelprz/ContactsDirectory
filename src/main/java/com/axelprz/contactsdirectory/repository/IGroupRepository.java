package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByName(String name);
}

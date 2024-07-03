package com.axelprz.contactsdirectory.repository;

import com.axelprz.contactsdirectory.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State, Integer> {
}

package com.example.employeeportal.repository;

import com.example.employeeportal.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<ManagerModel, Long> {
    // Find a manager by their name (used as username)
    Optional<ManagerModel> findByName(String name);

}

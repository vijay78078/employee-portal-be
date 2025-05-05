package com.example.employeeportal.repository;

import com.example.employeeportal.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    // Find an employee by their system ID (or any unique identifier)
    Optional<EmployeeModel> findBySystemId(String systemId);


}

package com.example.employeeportal.service;

import com.example.employeeportal.model.EmployeeModel;
import com.example.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to import data (update or insert)
    public void importEmployeeData(List<EmployeeModel> employees) {
        for (EmployeeModel employee : employees) {
            // Check if the employee already exists based on a unique field (e.g., system_id)
            Optional<EmployeeModel> existingEmployee = employeeRepository.findByEmailId(employee.getEmailId());

            if (existingEmployee.isPresent()) {
                // If the employee exists, update the existing record
                EmployeeModel existing = existingEmployee.get();
                existing.setBenslId(employee.getBenslId());
                existing.setBillableStatus(employee.getBillableStatus());
                existing.setEmployeeStatus(employee.getEmployeeStatus());
                existing.setFullName(employee.getFullName());
                existing.setManagerId(employee.getManagerId());
                existing.setManagerName(employee.getManagerName());
                existing.setEmploymentType(employee.getEmploymentType());
                existing.setSystemId(employee.getSystemId());
                existing.setRole(employee.getRole());
                existing.setTeam(employee.getTeam());
                existing.setSkill(employee.getSkill());
                existing.setCritical(employee.getCritical());
                existing.setDojAllianz(employee.getDojAllianz());
                existing.setDolAllianz(employee.getDolAllianz());
                existing.setGrade(employee.getGrade());
                existing.setDesignation(employee.getDesignation());
                existing.setDojProject(employee.getDojProject());
                existing.setDolProject(employee.getDolProject());
                existing.setGender(employee.getGender());
                existing.setCompany(employee.getCompany());
                existing.setEmailId(employee.getEmailId());
                existing.setLocation(employee.getLocation());
                existing.setBillingRate(employee.getBillingRate());
                existing.setRateCard(employee.getRateCard());
                existing.setRemarks(employee.getRemarks());
                existing.setSwp_2025(employee.getSwp_2025());

                employeeRepository.save(existing); // Save the updated employee
            } else {
                // If the employee doesn't exist, save the new record
                employeeRepository.save(employee);
            }
        }
    }

    // You can also provide a method to export data (optional)
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel addEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    // ✅ Update an employee by ID
    public EmployeeModel updateEmployee(Long id, EmployeeModel updatedData) {
        Optional<EmployeeModel> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeModel existing = optionalEmployee.get();
            updateEmployeeFields(existing, updatedData);
            return employeeRepository.save(existing);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    // ✅ Delete an employee by ID
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete. Employee not found with ID: " + id);
        }
    }


    public Optional<EmployeeModel> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    // ✅ Helper method to update fields
    private void updateEmployeeFields(EmployeeModel existing, EmployeeModel updated) {
        existing.setBenslId(updated.getBenslId());
        existing.setBillableStatus(updated.getBillableStatus());
        existing.setEmployeeStatus(updated.getEmployeeStatus());
        existing.setFullName(updated.getFullName());
        existing.setManagerId(updated.getManagerId());
        existing.setManagerName(updated.getManagerName());
        existing.setEmploymentType(updated.getEmploymentType());
        existing.setSystemId(updated.getSystemId());
        existing.setRole(updated.getRole());
        existing.setTeam(updated.getTeam());
        existing.setSkill(updated.getSkill());
        existing.setCritical(updated.getCritical());
        existing.setDojAllianz(updated.getDojAllianz());
        existing.setDolAllianz(updated.getDolAllianz());
        existing.setGrade(updated.getGrade());
        existing.setDesignation(updated.getDesignation());
        existing.setDojProject(updated.getDojProject());
        existing.setDolProject(updated.getDolProject());
        existing.setGender(updated.getGender());
        existing.setCompany(updated.getCompany());
        existing.setEmailId(updated.getEmailId());
        existing.setLocation(updated.getLocation());
        existing.setBillingRate(updated.getBillingRate());
        existing.setRateCard(updated.getRateCard());
        existing.setRemarks(updated.getRemarks());
        existing.setSwp_2025(updated.getSwp_2025());
    }

}

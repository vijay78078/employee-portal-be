package com.example.employeeportal.service;

import com.example.employeeportal.dto.LoginRequestDTO;
import com.example.employeeportal.model.ManagerModel;
import com.example.employeeportal.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    // Method to validate manager login
    public boolean validateManagerLogin(LoginRequestDTO loginRequestDTO) {
        Optional<ManagerModel> manager = managerRepository.findByName(loginRequestDTO.getUsername());

        // Check if manager exists and if the password matches
        if (manager.isPresent() && manager.get().getPassword().equals(loginRequestDTO.getPassword())) {
            return true;
        }
        return false;
    }

    public Optional<ManagerModel> findByUsername(String username) {
        return managerRepository.findByName(username);
    }


}

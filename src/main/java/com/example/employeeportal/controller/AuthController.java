package com.example.employeeportal.controller;

import com.example.employeeportal.dto.LoginRequestDTO;
import com.example.employeeportal.model.ManagerModel;
import com.example.employeeportal.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private ManagerService managerService;

    /**
     * POST endpoint for login
     * @param loginRequestDTO Contains username and password for login
     * @return ResponseEntity with a map containing message and success flag
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        // Validate the login credentials
        boolean isValid = managerService.validateManagerLogin(loginRequestDTO);
        Optional<ManagerModel> optionalManager = managerService.findByUsername(loginRequestDTO.getUsername());
        // Create a map for the response body
        Map<String, Object> response = new HashMap<>();
        if (isValid) {
            ManagerModel manager = optionalManager.get();
            response.put("message", "Login successful");
            response.put("success", true);
            response.put("role", manager.getRole());
            response.put(("fullName"), manager.getFullName());
            response.put("emailid", manager.getEmailid());
            return ResponseEntity.ok(response); // HTTP status 200 OK
        } else {
            response.put("message", "Invalid username or password");
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // HTTP status 401 Unauthorized
        }
    }
}

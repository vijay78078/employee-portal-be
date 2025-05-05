package com.example.employeeportal.dto;

public class LoginRequestDTO {

    private String name;
    private String password;

    // Default constructor
    public LoginRequestDTO() {}

    // Getter and Setter for username
    public String getUsername() {
        return name;
    }
    public void setUsername(String username) {
        this.name = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.employeeportal.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class ManagerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String name; // This will be used as the login email

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String Email_Id;

    // Default constructor
    public ManagerModel() {}

    // All-arguments constructor
    public ManagerModel(Long id, String name, String password, String role, String fullName, String Email_Id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.Email_Id = Email_Id;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for password
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailid() {
        return Email_Id;
    }
    public void setEmailid(String Email_Id) {
        this.Email_Id = Email_Id;
    }
}

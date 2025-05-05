package com.example.employeeportal.dto;

import com.example.employeeportal.model.EmployeeModel;

public class EmployeeResponseDTO {
    private Long id;
    private String fullName;
    private String emailId;
    private String managerName;
    private boolean isReportee;

    // Constructors
    public EmployeeResponseDTO() {}
    public EmployeeResponseDTO(EmployeeModel employeeModel, boolean isReportee) {
        this.id = employeeModel.getId();
        this.fullName = employeeModel.getFullName();
        this.emailId = employeeModel.getEmailId();
        this.managerName = employeeModel.getManagerName();
        this.isReportee = isReportee;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public boolean isReportee() { return isReportee; }
    public void setReportee(boolean isReportee) { this.isReportee = isReportee; }
}

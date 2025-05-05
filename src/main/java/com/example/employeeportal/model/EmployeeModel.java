package com.example.employeeportal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Employment_Type")
    @Column(name = "Employment_Type")
    private String employmentType;

    @JsonProperty("Billable_Status")
    @Column(name = "Billable_Status")
    private String billableStatus;

    @JsonProperty("Employee_Status")
    @Column(name = "Employee_Status")
    private String employeeStatus;

    @JsonProperty("System_ID")
    @Column(name = "System_ID")
    private String systemId;

    @JsonProperty("Bensl_ID")
    @Column(name = "Bensl_ID")
    private String benslId;

    @JsonProperty("Full_Name")
    @Column(name = "Full_Name")
    private String fullName;

    @JsonProperty("Role")
    @Column(name = "Role")
    private String role;

    @JsonProperty("Skill")
    @Column(name = "Skill")
    private String skill;

    @JsonProperty("Team")
    @Column(name = "Team")
    private String team;

    @JsonProperty("Manager_Name")
    @Column(name = "Manager_Name")
    private String managerName;

    @JsonProperty("Manager_ID")
    @Column(name = "Manager_ID")
    private String managerId;

    @JsonProperty("Critical")
    @Column(name = "Critical")
    private String critical;

    @JsonProperty("DOJ_Allianz")
    @Column(name = "DOJ_Allianz")
    @JsonFormat(pattern = "yyyy-MM-dd")  // Adjust format if needed
    private LocalDate dojAllianz;

    @JsonProperty("DOL_Allianz")
    @Column(name = "DOL_Allianz")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dolAllianz;

    @JsonProperty("Grade")
    @Column(name = "Grade")
    private String grade;

    @JsonProperty("Designation")
    @Column(name = "Designation")
    private String designation;

    @JsonProperty("DOJ_Project")
    @Column(name = "DOJ_Project")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dojProject;

    @JsonProperty("DOL_Project")
    @Column(name = "DOL_Project")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dolProject;

    @JsonProperty("Gender")
    @Column(name = "Gender")
    private String gender;

    @JsonProperty("Company")
    @Column(name = "Company")
    private String company;

    @JsonProperty("Emailid")
    @Column(name = "Emailid")
    private String emailId;

    @JsonProperty("Location")
    @Column(name = "Location")
    private String location;

    @JsonProperty("BillingRate")
    @Column(name = "BillingRate")
    private String billingRate;

    @JsonProperty("Rate_Card")
    @Column(name = "Rate_Card")
    private String rateCard;

    @JsonProperty("Remarks")
    @Column(name = "Remarks")
    private String remarks;

    @JsonProperty("Swp_2025")
    @Column(name = "Swp_2025")
    private String swp_2025;

    public EmployeeModel() {
    }

    public EmployeeModel(
            String employmentType,
            String billableStatus,
            String employeeStatus,
            String systemId,
            String benslId,
            String fullName,
            String role,
            String skill,
            String team,
            String managerName,
            String managerId,
            String critical,
            LocalDate dojAllianz,
            LocalDate dolAllianz,
            String grade,
            String designation,
            LocalDate dojProject,
            LocalDate dolProject,
            String gender,
            String company,
            String emailId,
            String location,
            String billingRate,
            String rateCard,
            String remarks,
            String swp_2025
    ) {
        this.employmentType = employmentType;
        this.billableStatus = billableStatus;
        this.employeeStatus = employeeStatus;
        this.systemId = systemId;
        this.benslId = benslId;
        this.fullName = fullName;
        this.role = role;
        this.skill = skill;
        this.team = team;
        this.managerName = managerName;
        this.managerId = managerId;
        this.critical = critical;
        this.dojAllianz = dojAllianz;
        this.dolAllianz = dolAllianz;
        this.grade = grade;
        this.designation = designation;
        this.dojProject = dojProject;
        this.dolProject = dolProject;
        this.gender = gender;
        this.company = company;
        this.emailId = emailId;
        this.location = location;
        this.billingRate = billingRate;
        this.rateCard = rateCard;
        this.remarks = remarks;
        this.swp_2025 = swp_2025;
    }

    // Getters and Setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getBillableStatus() {
        return billableStatus;
    }

    public void setBillableStatus(String billableStatus) {
        this.billableStatus = billableStatus;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getBenslId() {
        return benslId;
    }

    public void setBenslId(String benslId) {
        this.benslId = benslId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public LocalDate getDojAllianz() {
        return dojAllianz;
    }

    public void setDojAllianz(LocalDate dojAllianz) {
        this.dojAllianz = dojAllianz;
    }

    public LocalDate getDolAllianz() {
        return dolAllianz;
    }

    public void setDolAllianz(LocalDate dolAllianz) {
        this.dolAllianz = dolAllianz;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDojProject() {
        return dojProject;
    }

    public void setDojProject(LocalDate dojProject) {
        this.dojProject = dojProject;
    }

    public LocalDate getDolProject() {
        return dolProject;
    }

    public void setDolProject(LocalDate dolProject) {
        this.dolProject = dolProject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(String billingRate) {
        this.billingRate = billingRate;
    }

    public String getRateCard() {
        return rateCard;
    }

    public void setRateCard(String rateCard) {
        this.rateCard = rateCard;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setSwp_2025(String swp_2025) {
        this.swp_2025 = swp_2025;
    }

    public String getSwp_2025() {
        return swp_2025;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "employmentType='" + employmentType + '\'' +
                ", billableStatus='" + billableStatus + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", systemId='" + systemId + '\'' +
                ", benslId='" + benslId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", skill='" + skill + '\'' +
                ", team='" + team + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerId='" + managerId + '\'' +
                ", critical='" + critical + '\'' +
                ", dojAllianz=" + dojAllianz +
                ", dolAllianz=" + dolAllianz +
                ", grade='" + grade + '\'' +
                ", designation='" + designation + '\'' +
                ", dojProject=" + dojProject +
                ", dolProject=" + dolProject +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", emailId='" + emailId + '\'' +
                ", location='" + location + '\'' +
                ", billingRate=" + billingRate +
                ", rateCard='" + rateCard + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

package com.example.employeeportal.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "feedback")
public class FeedbackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "rating")
    private int rating;

    @Column(name = "feedback_text", length = 1000)
    private String feedbackText;

    @Column(name = "date")
    private LocalDate date;  // Alternatively, use java.time.LocalDate if you're storing it as DATE type in DB

    @Column(name = "medium")
    private String medium;
    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}

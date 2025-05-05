package com.example.employeeportal.service;

import com.example.employeeportal.model.EmployeeModel;
import com.example.employeeportal.model.FeedbackModel;
import com.example.employeeportal.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public FeedbackModel saveFeedback(FeedbackModel feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<FeedbackModel> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public List<FeedbackModel> getFeedbacksByManager(String managerName) {
        return feedbackRepository.findByManagerName(managerName);
    }

    public List<FeedbackModel> getFeedbacksByEmployee(String employeeName) {
        return feedbackRepository.findByEmployeeName(employeeName);
    }

    // Fetch reportees based on manager's name
    public List<String> getReporteesByManagerName(String managerName) {
        return feedbackRepository.searchByManagerName(managerName);
    }

}

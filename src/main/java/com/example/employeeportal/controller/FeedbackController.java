package com.example.employeeportal.controller;

import com.example.employeeportal.model.EmployeeModel;
import com.example.employeeportal.model.FeedbackModel;
import com.example.employeeportal.repository.EmployeeRepository;
import com.example.employeeportal.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:4200") // Adjust Angular port if needed
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    private EmployeeRepository employeeRepository;

    // POST - Add feedback
    @PostMapping("/add")
    public FeedbackModel addFeedback(@RequestBody FeedbackModel feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    // GET - View all feedbacks
    @GetMapping("/all")
    public List<FeedbackModel> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    // GET - View feedbacks by Manager (Optional)
    @GetMapping("/manager/{managerName}")
    public List<FeedbackModel> getFeedbacksByManager(@PathVariable String managerName) {
        return feedbackService.getFeedbacksByManager(managerName);
    }

    // GET - View feedbacks by Employee (Optional)
    @GetMapping("/employee/{employeeName}")
    public List<FeedbackModel> getFeedbacksByEmployee(@PathVariable String employeeName) {
        return feedbackService.getFeedbacksByEmployee(employeeName);
    }

    // Endpoint: GET /api/feedback/reportees/{managerName}
    @GetMapping("/reportees/{managerName}")
    public ResponseEntity<List<String>> getReporteesByManagerName(@PathVariable String managerName) {
        try {
            System.out.println("Received manager name: " + managerName);
            List<String> reportees = feedbackService.getReporteesByManagerName(managerName);
            return ResponseEntity.ok(reportees);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}


package com.example.employeeportal.controller;

import com.example.employeeportal.model.EmployeeModel;
import com.example.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint to import employee data (update or insert)
    @PostMapping("/import")
    public ResponseEntity<Object> importEmployees(@RequestBody List<EmployeeModel> employees) {
        employeeService.importEmployeeData(employees);
        // Return a JSON object with a success message
        return ResponseEntity.ok().body(new ResponseMessage("Employee data imported successfully."));
    }

    // Endpoint to export all employee data (optional)
    @GetMapping("/export")
    public ResponseEntity<List<EmployeeModel>> exportEmployees() {
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employeeslist")
    public List<EmployeeModel> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeModel employee) {
        System.out.println("Received employee data: " + employee);
        EmployeeModel savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok().body(new ResponseMessage("Employee added successfully with ID: " + savedEmployee.getId()));
    }

    // ✅ Update employee
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeModel updatedEmployee) {
        EmployeeModel updated = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok().body(new ResponseMessage("Employee updated successfully with ID: " + updated.getId()));
    }

    // ✅ Delete employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().body(new ResponseMessage("Employee deleted successfully with ID: " + id));
    }


    // A simple DTO for response message
    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

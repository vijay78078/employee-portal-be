package com.example.employeeportal.repository;

import com.example.employeeportal.model.EmployeeModel;
import com.example.employeeportal.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {

    List<FeedbackModel> findByManagerName(String managerName);

    List<FeedbackModel> findByEmployeeName(String employeeName);

    @Query("SELECT e.fullName FROM EmployeeModel e WHERE LOWER(e.managerName) LIKE LOWER(CONCAT('%', :managerName, '%'))")
    List<String> searchByManagerName(@Param("managerName") String managerName);
}

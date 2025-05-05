package com.example.employeeportal.service;  // Change package as necessary

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testConnection() {
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("Test query result: " + result);
    }
}

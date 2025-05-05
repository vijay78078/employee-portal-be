package com.example.employeeportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Disable CSRF protection for the login endpoint
                .authorizeRequests()
                .antMatchers("/api/login", "/api/employees/import", "/api/employees/export", "/api/employees/employeeslist", "/api/feedback/add", "/api/feedback/all", "/api/feedback/manager/{managerName}", "/api/feedback/reportees/{managerName}", "/api/employees/add", "/api/employees/edit/{id}","/api/employees/delete/{id}").permitAll()  // Allow /login without authentication
                .anyRequest().authenticated();  // Secure all other endpoints
    }
}

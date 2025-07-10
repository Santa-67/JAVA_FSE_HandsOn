package com.cognizant.employeerest.controller;

import com.cognizant.employeerest.model.Employee;
import com.cognizant.employeerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees") // ✅ REST endpoint
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); // ✅ Delegates to service
    }

    @GetMapping("/employees/{id}") // ✅ Optional: Get employee by ID
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.get(id);
    }
}

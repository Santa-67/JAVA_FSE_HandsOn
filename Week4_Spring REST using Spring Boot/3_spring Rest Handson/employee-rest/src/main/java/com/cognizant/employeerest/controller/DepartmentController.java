package com.cognizant.employeerest.controller;

import com.cognizant.employeerest.model.Department;
import com.cognizant.employeerest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        System.out.println("DepartmentController: /departments called");
        return departmentService.getAllDepartments();
    }
}

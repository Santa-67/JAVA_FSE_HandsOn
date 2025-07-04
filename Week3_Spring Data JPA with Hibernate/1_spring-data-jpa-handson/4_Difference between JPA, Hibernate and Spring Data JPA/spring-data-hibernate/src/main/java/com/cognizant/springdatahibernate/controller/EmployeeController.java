package com.cognizant.springdatahibernate.controller;

import com.cognizant.springdatahibernate.model.Employee;
import com.cognizant.springdatahibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee add(@RequestBody Employee emp) {
        return service.save(emp);
    }

    @GetMapping
    public List<Employee> list() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestParam int salary) {
        service.updateSalary(id, salary);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}

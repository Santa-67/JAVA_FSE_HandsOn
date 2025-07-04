package com.cognizant.springdatahibernate.service;

import com.cognizant.springdatahibernate.model.Employee;
import com.cognizant.springdatahibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public Employee save(Employee emp) {
        return repository.save(emp);
    }
    

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void updateSalary(int id, int newSalary) {
        Employee emp = repository.findById(id).orElse(null);
        if (emp != null) {
            emp.setSalary(newSalary);
            repository.save(emp);
        }
    }
}

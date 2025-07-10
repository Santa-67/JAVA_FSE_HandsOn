package com.cognizant.employeerest.service;

import com.cognizant.employeerest.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service // ✅ Changed from @Component to @Service
public class EmployeeService {

    public static List<Employee> EMPLOYEE_LIST;

    public EmployeeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    @Transactional // ✅ Added for transactional support
    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    @Transactional
    public Employee get(int id) {
        return EMPLOYEE_LIST.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}

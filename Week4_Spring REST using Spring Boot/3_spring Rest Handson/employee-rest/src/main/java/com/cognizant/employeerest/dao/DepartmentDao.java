package com.cognizant.employeerest.dao;

import com.cognizant.employeerest.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    public static List<Department> DEPARTMENT_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}

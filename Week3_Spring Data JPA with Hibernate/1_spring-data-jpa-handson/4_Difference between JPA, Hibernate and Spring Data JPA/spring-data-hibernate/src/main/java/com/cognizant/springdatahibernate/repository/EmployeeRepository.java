package com.cognizant.springdatahibernate.repository;

import com.cognizant.springdatahibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

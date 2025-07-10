package com.cognizant.employeerest.model;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private Department department;
    private double salary;
    private boolean permanent;
    private List<Skill> skills; // ✅ Add this field

    // ✅ Constructors
    public Employee() {
    }

    public Employee(int id, String name, Department department, double salary, boolean permanent, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.permanent = permanent;
        this.skills = skills;
    }

    // ✅ Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department +
               ", salary=" + salary + ", permanent=" + permanent + ", skills=" + skills + "]";
    }
}

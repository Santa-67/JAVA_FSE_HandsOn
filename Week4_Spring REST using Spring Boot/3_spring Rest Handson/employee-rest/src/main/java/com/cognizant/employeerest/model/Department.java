package com.cognizant.employeerest.model;

public class Department {
    private int id;
    private String name;

    // Default constructor
    public Department() {
    }

    // Constructor with parameters (optional)
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

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

    // Optional: toString() method
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}

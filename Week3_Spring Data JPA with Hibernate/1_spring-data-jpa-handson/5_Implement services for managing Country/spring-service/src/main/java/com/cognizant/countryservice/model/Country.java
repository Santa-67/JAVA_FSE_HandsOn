package com.cognizant.countryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getter for code
    public String getCode() {
        return code;
    }

    // Setter for code
    public void setCode(String code) {
        this.code = code;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}

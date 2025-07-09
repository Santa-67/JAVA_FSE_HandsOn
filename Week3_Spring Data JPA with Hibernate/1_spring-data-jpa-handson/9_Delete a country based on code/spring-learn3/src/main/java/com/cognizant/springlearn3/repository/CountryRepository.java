package com.cognizant.springlearn3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.springlearn3.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}

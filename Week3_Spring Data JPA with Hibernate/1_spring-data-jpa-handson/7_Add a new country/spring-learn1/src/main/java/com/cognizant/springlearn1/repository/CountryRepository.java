package com.cognizant.springlearn1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.springlearn1.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
package com.cognizant.springlearn4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.springlearn4.model.Country;

import java.util.List;



public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Search countries containing a substring (case-sensitive)
    List<Country> findByNameContaining(String substring);

    // 2. Search countries containing a substring and return sorted
    List<Country> findByNameContainingOrderByNameAsc(String substring);

    // 3. Search countries that start with a specific alphabet
    List<Country> findByNameStartingWith(String prefix);
}
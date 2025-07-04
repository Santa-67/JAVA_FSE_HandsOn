package com.cognizant.countryservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.countryservice.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCase(String partialName);
}

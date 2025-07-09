package com.cognizant.springlearn2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.springlearn2.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}

package com.cognizant.springlearn3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn3.model.Country;
import com.cognizant.springlearn3.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String name) {
        Country country = countryRepository.findById(code).orElseThrow(() -> 
            new RuntimeException("Country not found with code: " + code));
        country.setName(name); // Update name
        countryRepository.save(country); // Save updated entity
    }
    
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
        System.out.println("Country with code " + code + " deleted.");
    }
}

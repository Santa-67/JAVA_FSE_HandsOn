package com.cognizant.countryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.countryservice.model.Country;
import com.cognizant.countryservice.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountry(String code) {
        return countryRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, String newName) {
        Country country = getCountry(code);
        country.setName(newName);
        return countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountries(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}

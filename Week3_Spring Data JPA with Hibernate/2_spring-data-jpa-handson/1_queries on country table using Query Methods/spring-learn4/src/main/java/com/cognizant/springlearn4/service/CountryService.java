package com.cognizant.springlearn4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn4.model.Country;
import com.cognizant.springlearn4.repository.CountryRepository;

import java.util.List;



@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountriesBySubstring(String sub) {
        return countryRepository.findByNameContaining(sub);
    }

    public List<Country> getCountriesBySubstringSorted(String sub) {
        return countryRepository.findByNameContainingOrderByNameAsc(sub);
    }

    public List<Country> getCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
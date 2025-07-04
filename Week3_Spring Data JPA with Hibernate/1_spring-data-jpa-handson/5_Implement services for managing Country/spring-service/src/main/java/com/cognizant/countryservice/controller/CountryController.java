package com.cognizant.countryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.countryservice.model.Country;
import com.cognizant.countryservice.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code, @RequestParam String name) {
        return countryService.updateCountry(code, name);
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> searchCountries(@RequestParam String name) {
        return countryService.searchCountries(name);
    }
}

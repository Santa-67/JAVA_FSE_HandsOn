package com.cognizant.splearn.controller;
import com.cognizant.splearn.service.exception.*;

import com.cognizant.splearn.model.Country;
import com.cognizant.splearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;
    

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Country Not found")
    public void handleCountryNotFoundException() {
        // No body needed if using reason
    }


    // Existing endpoints...

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry() with code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry()");
        return country;
    }

}

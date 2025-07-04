package com.cognizant.springlearn1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.springlearn1.model.Country;
import com.cognizant.springlearn1.service.CountryService;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Start");
        testAddCountry();
        LOGGER.info("End");
    }

    private void testAddCountry() throws Exception {
        Country country = new Country();
        country.setCoCode("XY");
        country.setCoName("Xylovania");

        countryService.addCountry(country);

        Country result = countryService.findCountryByCode("XY");
        LOGGER.debug("Added Country: {}", result);
    }
}
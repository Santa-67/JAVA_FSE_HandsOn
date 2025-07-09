package com.cognizant.springlearn3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springlearn3.service.CountryService;

@SpringBootApplication
public class SpringLearn2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringLearn2Application.class, args);
        CountryService countryService = context.getBean(CountryService.class);

        System.out.println("Start");

        // Update a country
        countryService.updateCountry("IN", "BCD"); // Example update for India

        // Delete a country (you can choose same or different code)
        countryService.deleteCountry("IN");

        System.out.println("End");
    }
}

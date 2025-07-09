package com.cognizant.springlearn4;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springlearn4.model.Country;
import com.cognizant.springlearn4.service.CountryService;

@SpringBootApplication
public class SpringLearn4Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringLearn4Application.class, args);
        CountryService countryService = context.getBean(CountryService.class);

        System.out.println("Start");

        // 1. Search by 'ou'
        System.out.println("-- Search by 'ou' --");
        List<Country> result1 = countryService.getCountriesBySubstring("ou");
        result1.forEach(c -> System.out.println(c.getCode() + " " + c.getName()));

        // 2. Sorted search by 'ou'
        System.out.println("-- Sorted search by 'ou' --");
        List<Country> result2 = countryService.getCountriesBySubstringSorted("ou");
        result2.forEach(c -> System.out.println(c.getCode() + " " + c.getName()));

        // 3. Starting with 'Z'
        System.out.println("-- Starting with Z --");
        List<Country> result3 = countryService.getCountriesStartingWith("Z");
        result3.forEach(c -> System.out.println(c.getCode() + " " + c.getName()));

        System.out.println("End");
    }
}
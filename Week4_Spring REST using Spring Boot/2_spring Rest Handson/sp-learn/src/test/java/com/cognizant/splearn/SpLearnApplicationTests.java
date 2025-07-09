package com.cognizant.splearn;

import com.cognizant.splearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        // ✅ Check if CountryController is loaded
        assertNotNull(countryController);
    }
    
    @Test
    public void testGetCountryException() throws Exception {
        // Try to get a country that doesn't exist (e.g., XX)
        ResultActions actions = mvc.perform(get("/countries/XX"));

        // Check that the response is a 400 Bad Request with the correct reason
        actions.andExpect(status().isBadRequest())
               .andExpect(status().reason("Country Not found"));
    }


    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/countries/IN"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").value("India"));
    }
}

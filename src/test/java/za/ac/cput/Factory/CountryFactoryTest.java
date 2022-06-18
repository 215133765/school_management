package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Country;

import static org.junit.jupiter.api.Assertions.*;
/**
 CountryFactoryTest.java
 CountryFactoryTest
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 June 2022
 */
class CountryFactoryTest {

    @Test
    void createCountry() {
        Country country = CountryFactory.createCountry("ZAR", "South Africa");
        assertNotNull(country);
        System.out.println(country);

    }
}
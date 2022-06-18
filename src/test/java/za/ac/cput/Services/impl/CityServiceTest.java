package za.ac.cput.Services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Country;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    void create() {
        City cities = CityFactory.createCity("CPT", "Cape Town",
                CountryFactory.createCountry("ZAR", "South Africa"));
        assertNotNull(this.cityService.create(cities));
    }

    @Test
    void read() {
        Country country=CountryFactory.createCountry("ZAR", "South Africa");
        assertNotNull(this.cityService.read(country));
    }

    @Test
    void update() {
        City cities = CityFactory.createCity("IR", "Irbid",
                CountryFactory.createCountry("JO", "Jordan"));
        assertNotNull(this.cityService.update(cities));
    }

    @Test
    void delete() {
        Country country=CountryFactory.createCountry("ZAR", "South Africa");
        assertTrue(this.cityService.delete(country));
    }
}
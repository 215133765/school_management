package za.ac.cput.Services.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.City;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;
import za.ac.cput.Repository.impl.CityRepository;
import za.ac.cput.Services.Interfaces.ICityService;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    private static ICityService cityService = CityService.getCityService();
    private static City city = CityFactory.createCity("CPT", "Cape Town",
            CountryFactory.createCountry("ZAR", "South Africa"));


    @Test
    void a_create() {
        City created;
        created = cityService.create(city);
        assertEquals(city.getCityId(), created.getCityId());
        assertEquals(city.getCityName(), created.getCityName());
        System.out.println("Create: " + '\n' + created);

    }

    @Test
    void b_read() {
        City read = cityService.read(city.getCityName());
        System.out.println("Read : " + '\n' + read);
    }

    @Test
    void c_update() {
        City.Builder builder = new City.Builder();
        builder.copy(city);
        builder.setCityId("PTA");
        builder.setCityName("Pretoria");
        builder.setCountry(CountryFactory.createCountry("ZAR", "Nambia"));
        City update = builder.build();
        System.out.println("Updated : " + '\n' + update);
    }

    @Test
    void d_delete() {
        boolean deleted = cityService.delete(city.getCityId());
        assertTrue(deleted);
        System.out.println("Deleted" + deleted);


    }
}
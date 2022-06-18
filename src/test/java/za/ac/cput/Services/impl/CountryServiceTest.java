package za.ac.cput.Services.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Country;
import za.ac.cput.Factory.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CountryServiceTest {

    @Autowired
    private static CountryService countryService = CountryService.getService();
    private static Country country = CountryFactory
            .createCountry("ZAR", "South Africa");

    @Test
    void a_create() {
        Country created = countryService.create(country);
        assertEquals(created.getId(), created.getId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Country read = countryService.read(country.getId());
        assertNotNull(read,"read: ");
        System.out.println(read);
    }

    @Test
    void c_update() {
        Country updated = new Country.Builder().copy(country).setId("SA").build();
        updated = countryService.update(updated);
        assertNotEquals(updated.getId(), country.getId());
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        assertEquals(countryService.getAll().size(),1);
        System.out.println(countryService.getAll());
    }

    @Test
    void e_delete() {
        boolean delete = countryService.delete(country.getId());
        assertTrue(delete);
    }

    @Test
    void getName() {
    }

}

package za.ac.cput.Services.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Country;
import za.ac.cput.Factory.AddressFactory;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {

    @Autowired
    private static AddressService service = AddressService.getService();
    private static Country country = CountryFactory.createCountry("USA", "United States of America");
    private static City city = CityFactory.createCity("ALB", "A Town", country);
    private static Address address = AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785, city);

    @Test
    void a_create() {
        Address create = service.create(address);
        assertEquals(create.getUnitNumber(),address.getUnitNumber());
        System.out.println("Created from address: " + create);
    }

    @Test
    void b_read() {
        Address read = service.read(address.getUnitNumber());
        assertNotNull(read,"read my address");
        System.out.println(read);
    }


    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setStreetName("That").build();
        updated = service.update(updated);
        assertNotEquals(updated.getStreetName(), address.getStreetName());
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        assertEquals(service.getAll().size(),1);
        System.out.println(service.getAll());
    }
//
    @Test
    void e_delete() {
        boolean delete = service.delete(address.getUnitNumber());
        assertTrue(delete);
    }
}
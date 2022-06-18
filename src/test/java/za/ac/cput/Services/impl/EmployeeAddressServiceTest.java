package za.ac.cput.Services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Factory.AddressFactory;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;
import za.ac.cput.Factory.EmployeeAddressFactory;
import za.ac.cput.Repository.impl.EmployeeAddressRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressServiceTest {

    @Autowired
    private EmployeeAddressService employeeAddressService;


    @Test
    void read() {
        Address address=AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                CityFactory.createCity("CPT", "Cape Town",
                        CountryFactory.createCountry("ZAR", "South Africa")));
        assertNotNull(this.employeeAddressService.read(address));
    }

    @Test
    void update() {
        EmployeeAddress empAddress = EmployeeAddressFactory.createEmployeeAddress("x1077495",
                AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                        CityFactory.createCity("CPT", "Cape Town",
                                CountryFactory.createCountry("ZAR", "South Africa"))));

        assertNotNull(this.employeeAddressService.update(empAddress));
    }

    @Test
    void delete() {
        Address address=AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                CityFactory.createCity("CPT", "Cape Town",
                        CountryFactory.createCountry("ZAR", "South Africa")));
        assertTrue(this.employeeAddressService.delete(address));
    }

    @Test
    void create() {
        EmployeeAddress empAddress = EmployeeAddressFactory.createEmployeeAddress("x1077495",
                AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                        CityFactory.createCity("CPT", "Cape Town",
                                CountryFactory.createCountry("ZAR", "South Africa"))));

        assertNotNull(this.employeeAddressService.create(empAddress));
    }
}
package za.ac.cput.Services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Factory.AddressFactory;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;
import za.ac.cput.Factory.EmployeeAddressFactory;
import za.ac.cput.Repository.impl.EmployeeAddressRepository;
import za.ac.cput.Services.Interfaces.ICityService;
import za.ac.cput.Services.Interfaces.IEmployeeAddressService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressServiceTest {

    private static IEmployeeAddressService employeeAddressService = EmployeeAddressService.employeeAddressService();
    private static EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("x1077495",
            AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                    CityFactory.createCity("CPT", "Cape Town",
                            CountryFactory.createCountry("ZAR", "South Africa"))));


    @Test
    void create() {
        EmployeeAddress created;
        created = employeeAddressService.create(employeeAddress);
        assertEquals(employeeAddress.getStaffId(), created.getStaffId());
        assertEquals(employeeAddress.getAddress(), created.getAddress());
        System.out.println("Create: " + '\n' + created);

    }

    @Test
    void read() {

        EmployeeAddress read = employeeAddressService.read(employeeAddress.getStaffId());
        System.out.println("Read : " + '\n' + read);
    }

    @Test
    void update() {
        EmployeeAddress.Builder builder = new EmployeeAddress.Builder();
        builder.copy(employeeAddress);
        builder.setStaffId("x1022011");
        builder.setAddress( AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                CityFactory.createCity("CPT", "Cape Town", CountryFactory.createCountry("ZAR", "South Africa"))
        ));
        EmployeeAddress update = builder.build();
        System.out.println("Updated : " + '\n' + update);
    }

    @Test
    void delete() {
        boolean deleted = employeeAddressService.delete(employeeAddress.getStaffId());
        assertTrue(deleted);
        System.out.println("Deleted" + deleted);


    }
}
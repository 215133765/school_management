/**
 * Mandisa Msongelwa
 * Student number: 217149073
 * StudentAddressServiceTest
 */

package za.ac.cput.Services.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Country;
import za.ac.cput.Domain.StudentAddress;
import za.ac.cput.Factory.AddressFactory;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.CountryFactory;
import za.ac.cput.Factory.StudentAddressFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StudentAddressServiceTest {

    @Autowired
    private static StudentAddressService studentAddressService = StudentAddressService.getService();
    private static Country country = CountryFactory.createCountry("USA", "United States of America");
    private static City city = CityFactory.createCity("ALB", "A Town", country);
    private static Address address = AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785, city);

    private static StudentAddress studentAddress = StudentAddressFactory.buildStudentAddress("Mso101", address);

    @Test
    void a_create() {
        StudentAddress create = studentAddressService.create(studentAddress);
        assertEquals(create.getStudentId(), studentAddress.getStudentId());
        System.out.println("Student Address Service created: " + create);
    }

    @Test
    void b_read() {
        StudentAddress read = studentAddressService.read(studentAddress.getStudentId());
        assertNotNull(read);
        System.out.println("Student Read: " + read);
    }

    @Test
    void c_update() {
        StudentAddress updated = new StudentAddress.Builder().copy(studentAddress).build();
        assertNotEquals(updated.getStudentId(), studentAddressService.update(updated));
        System.out.println("Student Updated: " + updated);
    }

    @Test
    boolean d_delete() {
        boolean success = studentAddressService.delete(studentAddress.getStudentId());
        assertTrue(success);
        System.out.println("Student deleted: " + success);
        return true;
    }
}


















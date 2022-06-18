/**
 * Mandisa Msongelwa
 * Student number: 217149073
 * StudentAddressFactoryTest.java
 */

package za.ac.cput.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAddressFactoryTest {

    @Test
    void buildStudentAddress() {
        Address studentAddress = AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785,
                CityFactory.createCity("CPT", "Cape Town", CountryFactory.createCountry("ZAR", "South Africa")));
        assertNotNull(studentAddress);
        System.out.println("Student Address" + studentAddress);
    }
}

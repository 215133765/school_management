package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.*;
import za.ac.cput.Factory.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeAddressControllerTest {

    private static Country country = CountryFactory.createCountry("USA", "United States of America");
    private static City city = CityFactory.createCity("ALB", "A Town", country);
    private static Address address = AddressFactory.createAddress("35","Tafelsig","45","Alps Street",7785, city);
    private static EmployeeAddress empAddress = EmployeeAddressFactory.createEmployeeAddress("x1077495",address);


    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/employee";

    @Test
    void a_create() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/employee", null, String.class);
        String url = BASE_URL + "/create";
        ResponseEntity<EmployeeAddress> postResponse = restTemplate.postForEntity(url, empAddress, EmployeeAddress.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        empAddress = postResponse.getBody();
        System.out.println("Saved data " + postResponse.getBody());
        assertEquals(empAddress.getStaffId(), postResponse.getBody().getAddress());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + empAddress.getStaffId();
        System.out.println("URL: " + url);
        ResponseEntity<Student> getResponse = restTemplate.getForEntity(url, Student.class);
        assertEquals(empAddress.getStaffId(), getResponse.getBody().getEmail());
    }
    @Test
    void c_update() {
        EmployeeAddress updated = new EmployeeAddress.Builder().copy(empAddress).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        restTemplate.put(url, updated, EmployeeAddress.class);
        ResponseEntity<EmployeeAddress> putResponse = restTemplate.getForEntity(url, EmployeeAddress.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + empAddress.getStaffId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}
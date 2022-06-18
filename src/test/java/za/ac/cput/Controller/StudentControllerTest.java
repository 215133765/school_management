package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Domain.Name;
import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.NameFactory;
import za.ac.cput.Factory.StudentFactory;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    private static Name name = NameFactory.createName("Buko", "BK", "Ramncwana");
    private static Student student = StudentFactory.buildStudent("Mso101", "mso101@mycput.ac.za", name);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/student";

    @Test
    void a_create() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/student", null, String.class);
        String url = BASE_URL + "/create";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        student = postResponse.getBody();
        System.out.println("Saved data " + postResponse.getBody());
        assertEquals(student.getStudentId(), postResponse.getBody().getStudentId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + student.getStudentId();
        System.out.println("URL: " + url);
        ResponseEntity<Student> getResponse = restTemplate.getForEntity(url, Student.class);
        assertEquals(student.getStudentId(), getResponse.getBody().getStudentId());
    }

    @Test
    void c_update() {
        Student updated = new Student.Builder().copy(student).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        restTemplate.put(url, updated, Student.class);
        ResponseEntity<Student> putResponse = restTemplate.getForEntity(url, Student.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + student.getStudentId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Data: " + getResponse.getBody());
        assertNotNull(getResponse);
    }

}
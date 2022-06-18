/**
 * Mandisa Msongelwa
 * Student number: 217149073
 * StudentServiceTest.java
 */

package za.ac.cput.Services.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.Name;
import za.ac.cput.Factory.NameFactory;
import za.ac.cput.Factory.StudentFactory;


@TestMethodOrder(MethodOrderer.MethodName.class)

public class StudentServiceTest {

    @Autowired
    private static StudentService studServ = StudentService.getStudentService();
    private static Name name = NameFactory.createName("Buko", "BK", "Ramncwana");
    private static Student student = StudentFactory.buildStudent("Mso101", "mso101@mycput.ac.za", name);

    @Test
    void create() {
        Student created = studServ.create(student);
        assertEquals(created.getStudentId(), student.getStudentId());
        System.out.println("Student Service created: " + created);
    }

    @Test
    void read() {
        Student read = studServ.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Student Read: " + read);
    }

    @Test
    void update() {
        Student updated = new Student.Builder().copy(student).build();
        assertNotEquals(updated.getStudentId(), studServ.update(updated));
        System.out.println("Student Updated: " + updated);
    }

    @Test
    boolean delete() {
        boolean success = studServ.delete(student.getStudentId());
        assertTrue(success);
        System.out.println("Student deleted: " + success);
        return true;
    }
}








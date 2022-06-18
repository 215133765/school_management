package za.ac.cput.Services.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.Name;
import za.ac.cput.Factory.NameFactory;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Services.impl.StudentService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StudentServiceTest {

    @Autowired
    private static StudentService studentService = StudentService.getStudentService();
    private static Name name = NameFactory.createName("Buko", "BK", "Ramncwana");
    private static Student student = StudentFactory.buildStudent("Mso101", "mso101@mycput.ac.za", name);

    @Test
    void a_create() {
        Student created = studentService.create(student);
        assertEquals(created.getStudentId(), student.getStudentId());
        System.out.println("Student Service created: " + created);
    }

    @Test
    void b_read() {
        Student read = studentService.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Student Read: " + read);
    }

    @Test
    void c_update() {
        Student updated = new Student.Builder().copy(student).build();
        assertNotEquals(updated.getStudentId(), studentService.update(updated));
        System.out.println("Student Updated: " + updated);
    }
//
    @Test
    void d_delete() {
        boolean success = studentService.delete(student.getStudentId());
        assertTrue(success);
        System.out.println("Student deleted: " + success);
    }
}








/**
 * Mandisa Msongelwa
 * Student number: 217149073
 * StudentFactoryTest.java
 */

package za.ac.cput.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void buildStudent() {
        Student student = StudentFactory.buildStudent("Mso101", "mso101@mycput.ac.za", NameFactory.createName("Buko", "BK", "Ramncwana"));
        assertNotNull(student);
        System.out.println(student);

    }
}

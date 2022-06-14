package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Employee;
import za.ac.cput.Domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    void createEmployee(){
        Employee employee = EmployeeFactory.createEmployee("22334455","nikitha@gmail.com",NameFactory.createName("Nikitha", "Lona", "Mbokotwana"));
        System.out.println(employee.toString());
        assertNotNull(employee);
    }
}
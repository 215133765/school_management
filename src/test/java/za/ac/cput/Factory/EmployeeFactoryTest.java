/**
 * EmployeeFactory.java
 * Author: Nikitha Mbokotwana
 * Question 2: Implemenation of Employee factory Test
 * Group: 28
 * Created: 10/6/2022
 * */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void createEmployeeWithSuccess(){
        Employee employee = EmployeeFactory.createEmployee("22335566", "nikitha@gmail.com",
                NameFactory.createName("Nikitha", "Lona", "Mbokotwana"));
        assertNotNull(employee);
        System.out.println(employee);
    }
    @Test
    public void createEmployeeWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployee("", "nikitha@gmail.com",
                        NameFactory.createName("Nikitha", "Lona", "Mbokotwana"))
        );
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staffId is required", exceptionMessage);
    }


}

package za.ac.cput.Services.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Employee;
import za.ac.cput.Factory.EmployeeFactory;
import za.ac.cput.Factory.NameFactory;
import za.ac.cput.Services.Interfaces.IEmployeeServices;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServicesTest {
    @Autowired
    private static IEmployeeServices employeeServices = EmployeeServices.getEmployeeServices();
    private static Employee employee1 = EmployeeFactory
            .createEmployee("22336655", "nikitha@gail.com",
                    NameFactory.createName("Nikitha","Lona","Mbokotwana"));
    private static Employee employee2 = EmployeeFactory
            .createEmployee("22336656", "Emihle@gail.com",
                    NameFactory.createName("Emihle","emza","Lena"));

    //Question 4: A
    @Test
    void a_create() {
        Employee created = employeeServices.create(employee1);
        assertEquals(created.getStaffId(), employee1.getStaffId());
        System.out.println(created);
    }

    @Test
    void c_update() {
        Employee.Builder builder = new Employee.Builder();
        builder.copy(employee1);
        builder.setEmail("lonambokotwana@gmail.com");
        Employee update = builder.build();
        System.out.println("Updated : " + '\n'+ update);
    }

    //Question 4: B
    @Test
    void b_read() {
        Employee created = employeeServices.create(employee1);
        Employee read = employeeServices.read(employee1.getEmail());
        System.out.println(read);
    }

    //Question 4: C
    @Test
    void delete() {
        boolean success = employeeServices.delete(employee2.getStaffId());
        assertTrue(success);
    }

    //Question 4: D
    @Test void findAll(){
        List<Employee> employeeList = employeeServices.findAll();
        employeeList.forEach(employee -> System.out.println(employee.toString()));
    }
    //Question 5:
    @Test
    void getEmployeeName(){


    }

}

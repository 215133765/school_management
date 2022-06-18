/**
 * EmployeeFactory.java
 * Author: Nikitha Mbokotwana
 * Question 2: Implemenation of Employee factory
 * Group: 28
 * Created: 10/6/2022
 * */
package za.ac.cput.Factory;

import za.ac.cput.Domain.Employee;
import za.ac.cput.Domain.Name;
import za.ac.cput.Utility.Helper;

public class EmployeeFactory {
    public static Employee createEmployee(String staffId, String email, Name name) {
        Helper.checkStringParam("staffId", staffId);
        return new Employee.Builder()
                .setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}


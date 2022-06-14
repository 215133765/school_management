/*EmployeeFactory.java
Factory Class for Employee
Author: Nikitha Mbokotwana (218337906)
Date: 10 June 2022
 */
package za.ac.cput.Factory;

import za.ac.cput.Domain.Employee;
import za.ac.cput.Domain.Name;

public class EmployeeFactory {
    //creating employee object
    public static Employee createEmployee(String staffId, String email, Name name){
        return new Employee.Builder()
                .setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }

}

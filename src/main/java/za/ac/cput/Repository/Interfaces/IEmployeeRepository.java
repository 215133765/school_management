/**
 * Author: Nikitha Mbokotwana 218337906
 * POJO IEmployeeRepository.java
 *  Employee Interface file to be implemented
 * Created: 12/6/2022
 * */
package za.ac.cput.Repository.Interfaces;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Employee;
import za.ac.cput.Repository.IRepository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends IRepository<Employee, String> {
    public List<Employee> findAll();
    public List<Employee> getEmployeeName();
}

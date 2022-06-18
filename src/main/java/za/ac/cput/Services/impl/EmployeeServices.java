package za.ac.cput.Services.impl;
import za.ac.cput.Domain.Employee;
import za.ac.cput.Repository.Interfaces.IEmployeeRepository;
import za.ac.cput.Repository.impl.EmployeeRepository;
import za.ac.cput.Services.Interfaces.IEmployeeServices;

import java.util.List;

public class EmployeeServices implements IEmployeeServices {
    private static IEmployeeServices employeeServices;
    private IEmployeeRepository employeeRepository;
    private EmployeeServices(){
        this.employeeRepository = EmployeeRepository.getEmployeeRepository();
    }
    public static IEmployeeServices getEmployeeServices(){
        if(employeeServices == null)
            employeeServices = new EmployeeServices();
        return employeeServices;
    }
    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee read(String employee) {
        return this.employeeRepository.read(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public boolean delete(String s) {this.employeeRepository.delete(s);
        return true;
    }
    public List<Employee> findAll(){
        return this.employeeRepository.findAll();
    }
    public List<Employee> getEmployeeName(String email){
        return this.employeeRepository.getEmployeeName();
    }

}

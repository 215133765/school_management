package za.ac.cput.Repository.impl;

import za.ac.cput.Domain.Employee;
import za.ac.cput.Repository.Interfaces.IEmployeeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {
    private Set<Employee> employees;
    private List<Employee> employeeList;
    private static IEmployeeRepository employeeRepository;

    private EmployeeRepository(){
        this.employees = new HashSet<>();
        this.employeeList = new ArrayList<>();
    }

    public static IEmployeeRepository getEmployeeRepository(){
        if (employeeRepository == null)
            employeeRepository = new EmployeeRepository();
        return employeeRepository;
    }

    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    public Employee read(String em) {
        Employee employee = this.employees.stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(em))
                .findAny().orElse(null);
        return employee;
    }

    public Employee update(Employee employee) {
        Employee emp = read(employee.getEmail());
        if (emp != null) {
            Employee updated = new Employee.Builder().copy(emp)
                    .setStaffId(employee.getStaffId())
                    .build();
        }
        return emp;
    }

    public boolean delete(String e) {
        Employee employee = read(e);
        this.employees.remove(employee);
        return true;
    }
    public List<Employee> findAll(){
        return this.employeeList;
    }

    @Override
    public List<Employee> getEmployeeName() {
        return this.employeeList;
    }


}

package za.ac.cput.Repository.impl;

import za.ac.cput.Domain.City;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Repository.Interfaces.IEmployeeAddressRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeAddressRepository implements IEmployeeAddressRepository {

    private Set<EmployeeAddress> employeeAddresses;
    private  static EmployeeAddressRepository employeeAddressRepository;

    private EmployeeAddressRepository() {
        this.employeeAddresses = new HashSet<>();

    }

    public static IEmployeeAddressRepository getEmployeeAddressRepository(){
        if (employeeAddressRepository == null){
            employeeAddressRepository = new EmployeeAddressRepository();
        }
        return employeeAddressRepository;
    }

    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress){
        this.employeeAddresses.add(employeeAddress);

        return employeeAddress;
    }

    @Override
    public EmployeeAddress read(String employeeAddress){
        EmployeeAddress employeeAddress1 = this.employeeAddresses.stream()
                .filter(s -> s.getStaffId().equalsIgnoreCase(employeeAddress))
                .findAny()
                .orElse(null);
        return employeeAddress1;
    }

    @Override
    public EmployeeAddress update(EmployeeAddress employeeAddress){
        EmployeeAddress empAddress = read(employeeAddress.getStaffId());

        if (empAddress != null){
            EmployeeAddress updted = new EmployeeAddress.Builder().copy(empAddress).setStaffId(employeeAddress.getStaffId()).build();
            delete(empAddress.getStaffId());
            this.employeeAddresses.add(updted);
        }
        return empAddress;
    }

    @Override
    public boolean delete(String del){
        EmployeeAddress employeeAddress = read(del);
        if (employeeAddress  == null){
            return false;
        }
        employeeAddresses.remove(employeeAddress);
        return  true;
    }
    public Set<EmployeeAddress> getAll() {
        return employeeAddresses;
    }
}
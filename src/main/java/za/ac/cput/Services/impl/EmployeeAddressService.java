package za.ac.cput.Services.impl;

import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Repository.Interfaces.IEmployeeAddressRepository;
import za.ac.cput.Repository.impl.EmployeeAddressRepository;
import za.ac.cput.Services.Interfaces.IEmployeeAddressService;

public class EmployeeAddressService implements IEmployeeAddressService {

    private static IEmployeeAddressService employeeAddressService;
    private IEmployeeAddressRepository employeeAddressRepository;

    private EmployeeAddressService() {
        this.employeeAddressRepository = EmployeeAddressRepository.getEmployeeAddressRepository();
    }

    public static IEmployeeAddressService employeeAddressService(){
        if (employeeAddressService == null){
            employeeAddressService = new EmployeeAddressService();
        }
        return employeeAddressService;
    }

    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress){
        return this.employeeAddressRepository.create(employeeAddress);
    }

    @Override
    public EmployeeAddress read(String employeeAddress){
        return this.employeeAddressRepository.read(employeeAddress);
    }

    @Override
    public
     EmployeeAddress update(EmployeeAddress employeeAddress){
        return  this.employeeAddressRepository.update(employeeAddress);
    }

    @Override
    public void delete(String empAddress){
        this.employeeAddressRepository.delete(empAddress);
    }
}

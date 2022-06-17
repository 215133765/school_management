//package za.ac.cput.Services.impl;
///**
// * Author: Mziyanda Mwanda 215133765
// * POJO EmployeeAddressService.java
// *  EmployeeAddress Service file to be implemented
// * Created: 13/6/2022
// * */
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.Domain.Address;
//import za.ac.cput.Domain.EmployeeAddress;
//import za.ac.cput.Repository.Interfaces.IEmployeeAddressRepository;
//import za.ac.cput.Services.Interfaces.IEmployeeAddressService;
//
//import java.util.List;
//
//public abstract class EmployeeAddressServiceTol implements IEmployeeAddressService {
//
//    @Autowired
//    private IEmployeeAddressRepository employeeAddressRepository;
//
//    public EmployeeAddress read (Address address){
//
//        return this.employeeAddressRepository.findById(address.getStreetName()).orElse(null);
//    }
//
//
//    @Override
//    public EmployeeAddress update(EmployeeAddress employeeAddress){
//
//        return this.employeeAddressRepository.save(employeeAddress);
//    }
//
//    public boolean delete (Address address){
//        this.employeeAddressRepository.deleteById(address.getStreetName());
//        return !this.employeeAddressRepository.existsById(address.getStreetName());
//    }
//
//    @Override
//    public EmployeeAddress create(EmployeeAddress employeeAddress){
//        return this.employeeAddressRepository.save(employeeAddress);
//    }
//
//
//    @Override
//    public List<EmployeeAddress> getAll(){
//        return this.employeeAddressRepository.findAll();
//    }
//
//
//
//}

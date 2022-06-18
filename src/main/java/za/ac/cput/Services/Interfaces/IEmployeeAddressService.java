package za.ac.cput.Services.Interfaces;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO IEmployeeAddressService.java
 *  EmployeeAddress Service Interface file to be implemented
 * Created: 13/6/2022
 * */
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Services.IService;

import java.util.List;
import java.util.Set;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    Set<EmployeeAddress> getAll();
}

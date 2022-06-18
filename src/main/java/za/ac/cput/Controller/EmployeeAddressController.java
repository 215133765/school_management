package za.ac.cput.Controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.AddressFactory;
import za.ac.cput.Factory.EmployeeAddressFactory;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Repository.Interfaces.IAddressRepository;
import za.ac.cput.Repository.Interfaces.IEmployeeAddressRepository;
import za.ac.cput.Services.Interfaces.IAddressService;
import za.ac.cput.Services.Interfaces.IEmployeeAddressService;
import za.ac.cput.Services.Interfaces.IStudentAddressService;
import za.ac.cput.Services.impl.EmployeeAddressService;

@Controller
@RequestMapping("/address/employee/")
public class EmployeeAddressController {

    @Autowired
    private IEmployeeAddressService employeeAddressService;
    @Autowired
    private IAddressService addressService;

    @PostMapping(value = "create")
    public EmployeeAddress create(@RequestBody @NotNull EmployeeAddress employeeAddress) {
        EmployeeAddress newEmployeeAddress = EmployeeAddressFactory.createEmployeeAddress(employeeAddress.getStaffId(), employeeAddress.getAddress());
        return employeeAddressService.create(newEmployeeAddress);
    }

    @GetMapping(value = "read/{staffId}")
    public EmployeeAddress read(@PathVariable String staffId) {
        return employeeAddressService.read(staffId);
    }

    @PutMapping(value = "update")
    public EmployeeAddress update(@RequestBody EmployeeAddress employeeAddress) {
        return employeeAddressService.update(employeeAddress);
    }

    @DeleteMapping(value = "delete/{staffId}")
    public boolean delete(@PathVariable String staffId) {
        return employeeAddressService.delete(staffId);
    }


}

package za.ac.cput.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.ac.cput.Domain.City;
import za.ac.cput.Services.impl.*;

import java.awt.*;

@RestController
@RequestMapping("/school_management/city")
public class CityController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private CityService cityService;
    @Autowired
    private EmployeeAddressService employeeAddressService;
    @Autowired
    private StudentAddressService studentAddressService;
    @Autowired
    private StudentService studentService;

    @PostMapping(value  = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCity(@RequestBody NewCity city){
        System.out.println(city);

        ResponseObj responseObj = ResponseObj.buildGenericResponsseObj(HttpStatus.OK.toString(), "City created");

        if (city.getCityId() == null || city.getCityName() == null){
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Please provide city and/or city name!");
        }else{
            City city1 = getCity(city);

        }
    }

}

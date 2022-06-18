package za.ac.cput.Controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.CityFactory;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Services.impl.AddressService;
import za.ac.cput.Services.impl.CityService;
import za.ac.cput.Services.impl.StudentAddressService;
import za.ac.cput.Services.impl.StudentService;

@Controller
@RequestMapping("/City/")
public class CityController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentAddressService studentAddressService;
    @Autowired
    private AddressService service;
    @Autowired
    private CityService cityService;

    @PostMapping(value = "create")
    public City create(@RequestBody @NotNull City city) {
        City newCity = CityFactory.createCity(city.cityId, city.getCityName(), city.getCountry());
        return cityService.create(newCity);
    }

    @GetMapping(value = "read/{cityId}")
    public City read(@PathVariable String cityId) {
        return cityService.read(cityId);
    }

    @PutMapping(value = "update")
    public City update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping(value = "delete/{cityId}")
    public boolean delete(@PathVariable String cityId) {
        return cityService.delete(cityId);
    }

}

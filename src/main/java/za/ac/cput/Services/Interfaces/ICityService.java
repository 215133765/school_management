package za.ac.cput.Services.Interfaces;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO ICityService.java
 *  City Service Interface file to be implemented
 * Created: 13/6/2022
 * */
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.City;
import za.ac.cput.Services.IService;
import java.util.List;
import java.util.Set;

public interface ICityService extends IService<City, String>{
    Set<City> getAll();
    List<City> findbyCityId(String cityId);
}

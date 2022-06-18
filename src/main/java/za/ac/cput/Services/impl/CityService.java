package za.ac.cput.Services.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.City;
import za.ac.cput.Repository.Interfaces.ICityRepository;
import za.ac.cput.Repository.impl.CityRepository;
import za.ac.cput.Services.Interfaces.ICityService;

@Service
public class CityService implements ICityService {

    private static ICityService cityService;
    private ICityRepository cityRepository;

    private CityService(){
        this.cityRepository = CityRepository.getCityRepository();
    }
    public static ICityService getCityService(){
        if (cityService == null){
            cityService = new CityService();
        }
        return cityService;
    }

    @Override
    public City create(City city){
        return this.cityRepository.create(city);
    }

    @Override
    public City read(String city){
        return this.cityRepository.read(city);
    }

    @Override
    public City update(City city){
        return this.cityRepository.update(city);
    }

    @Override
    public boolean delete(String cit){
       this.cityRepository.delete(cit);
        return cit;
    }

}

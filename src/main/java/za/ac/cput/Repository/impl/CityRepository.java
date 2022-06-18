package za.ac.cput.Repository.impl;

import za.ac.cput.Domain.City;
import za.ac.cput.Repository.Interfaces.ICityRepository;

import java.util.HashSet;
import java.util.Set;

public class CityRepository implements ICityRepository {

    private Set<City> cities;
    private static ICityRepository cityRepository;

    private CityRepository(){
        this.cities = new HashSet<>();
    }

    public static ICityRepository getCityRepository(){
        if (cityRepository == null){
            cityRepository =  new CityRepository();
        }
        return cityRepository;
    }

    @Override
    public City create(City city){
        this.cities.add(city);

        return city;
    }

    @Override
    public City read (String citi){
        City city = this.cities.stream().filter( e -> e.getCityName().equalsIgnoreCase(citi)).findAny().orElse(null);

        return city;
    }

    @Override
    public City update(City city){
        City cit = read(city.getCityId());

        if (cit != null){
            City updated = new City.Builder().copy(cit).setCityId(city.getCityId()).build();
            cit = updated;

        }

        return cit;
    }

    @Override
    public void delete(String deleted){
        City city = read(deleted);
        this.cities.remove(city);
    }

    public Set<City> getAll(){
        return cities;
    }
}

package za.ac.cput.Repository.impl;

import za.ac.cput.Domain.City;
import za.ac.cput.Repository.Interfaces.ICityRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CityRepository implements ICityRepository {

    private Set<City> cities;
    private static CityRepository cityRepository;

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
        boolean created = cities.add(city);
        if (!created){
            return null;
        }
        return city;
    }

    @Override
    public City read (String citi){
        City city = this.cities.stream().
                filter( e -> e.getCityName().equalsIgnoreCase(citi))
                .findAny()
                .orElse(null);

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
    public boolean delete(String deleted){
        City city = read(deleted);

        if (city  == null){
            return false;
        }
        cities.remove(city);
        return  true;
    }
    public Set<City> getAll() {
        return cities;
    }

    public List<City> findbyCityId(String cityId){
        return  this.cities.stream()
                .filter(c -> c.getCityId().equalsIgnoreCase(cityId))
                .collect(Collectors.toList());
    }

}

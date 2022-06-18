package za.ac.cput.Repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Country;
import za.ac.cput.Repository.Interfaces.ICountryRepository;

import java.util.HashSet;
import java.util.Set;

public class CountryRepository implements ICountryRepository {

    private static CountryRepository countryRepository = null;
    private Set<Country> countrySet = null;

    private CountryRepository() {
        countrySet = new HashSet<>();
    }

    public static CountryRepository getCountryRepository()
    {
        if(countryRepository == null) {
            countryRepository = new CountryRepository();
        }
        return countryRepository;
    }

    @Override
    public Country create(Country country)
    {
        boolean successful = countrySet.add(country);
        if(!successful)
            return null;
        return country;
    }

    @Override
    public Country read(String s) {
        for(Country c : countrySet)
            if(c.getId()==s){
                return c;
            }
        return null;
    }

    @Override
    public Country update(Country country)
    {
        Country country1 = read(country.getId());

        if (country1 != null){
            countrySet.remove(country1);
            countrySet.add(country1);
            return country1;
        }
        return null;
    }

    @Override
    public boolean delete(String d)
    {
        Country delete = read(d);
        if(delete == null)
            return false;
        countrySet.remove(delete);
        return true;
    }

    public Set<Country> getAll() {
        return countrySet;
    }
}
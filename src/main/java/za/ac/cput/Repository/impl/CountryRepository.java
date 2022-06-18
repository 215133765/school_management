package za.ac.cput.Repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Country;
import za.ac.cput.Repository.Interfaces.ICountryRepository;

import java.util.List;

@Repository
public abstract class CountryRepository implements ICountryRepository {
    public Country readName (String country) {
        List<Country> countries = findAll();

        return countries.stream().findAny().orElse(null);
    }
}

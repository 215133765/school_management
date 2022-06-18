package za.ac.cput.Services.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Country;
import za.ac.cput.Repository.impl.CountryRepository;
import za.ac.cput.Services.Interfaces.ICountryService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryService implements ICountryService {

    private static CountryService service;
    private CountryRepository countryRepository;

    private CountryService() {this.countryRepository = CountryRepository.getCountryRepository();}
    public static CountryService getService() {
        if (service == null) service = new CountryService();
        return service;
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.create(country);
    }

    @Override
    public Country read(String add) {
        return this.countryRepository.read(add);
    }

    @Override
    public Country update(Country country) {
        return this.countryRepository.update(country);
    }

    @Override
    public boolean delete(String s) {
        this.countryRepository.delete(s);
        return true;
    }

    @Override
    public Set<Country> getAll() {
        return this.countryRepository.getAll();
    }

    @Override
    public Optional<Country> findByCountryId(String countryId) {
        return Optional.empty();

    }
}



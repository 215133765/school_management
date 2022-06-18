package za.ac.cput.Services.Interfaces;

import za.ac.cput.Domain.Country;
import za.ac.cput.Services.IService;

import java.util.Optional;
import java.util.Set;

public interface ICountryService extends IService<Country, String> {
    Set<Country> getAll();
    Optional<Country> findByCountryId(String countryId);
}

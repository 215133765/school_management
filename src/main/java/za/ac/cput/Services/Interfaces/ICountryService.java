package za.ac.cput.Services.Interfaces;

import za.ac.cput.Domain.Country;
import za.ac.cput.Services.IService;

import java.util.List;

public interface ICountryService extends IService<Country, String> {
    List<Country> getAll();
}

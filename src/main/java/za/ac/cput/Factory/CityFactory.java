package za.ac.cput.Factory;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO CityFactory.java
 *  City Factory file to be implemented
 * Created: 10/6/2022
 * */
import za.ac.cput.Domain.City;
import za.ac.cput.Domain.Country;
import za.ac.cput.Utility.Helper;

public class CityFactory {

    public static City createCity(String cityId, String cityName, Country country){
        Helper.checkStringParam("cityId", cityId);
            return new City.Builder()
                .setCityId(cityId)
                .setCityName(cityName)
                .setCountry(country)
                .build();
    }
}

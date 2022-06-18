package za.ac.cput.Repository.Interfaces;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO ICityRepository.java
 *  City Interface file to be implemented
 * Created: 12/6/2022
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.City;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ICityRepository extends IRepository<City, String> {

}

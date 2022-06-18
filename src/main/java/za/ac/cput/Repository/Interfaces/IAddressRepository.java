package za.ac.cput.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Address;
import za.ac.cput.Repository.IRepository;



public interface IAddressRepository extends IRepository<Address, String> {


}

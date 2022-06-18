package za.ac.cput.Repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Address;
import za.ac.cput.Repository.Interfaces.IAddressRepository;

import java.util.*;

@Repository
public class AddressRepository implements IAddressRepository {

    private static AddressRepository repository = null;
    private Set<Address> addressesDB = null;

    private AddressRepository() { this.addressesDB = new HashSet<>(); }

//    public Address fetchAddress (String address){
//
//        List<Address> addresses = findAll();
//
//        return addresses.stream().findAny().orElse(null);
//    }

    public static AddressRepository getRepository() {
        if (repository == null)
            repository = new AddressRepository();
        return repository;
    }

    @Override
    public Address create(Address address) {
        boolean created = addressesDB.add(address);
        if (!created)
            return null;
        return address;
    }

    @Override
    public Address read(String s) {
        for (Address a: addressesDB) {
            if (a.getUnitNumber().equals(s))
                return a;
        }
        return null;
    }

    @Override
    public Address update(Address address) {
        Address oldAddress = read(address.getUnitNumber());
        if (oldAddress != null) {
            addressesDB.remove(oldAddress);
            addressesDB.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Address deleted = read(s);
        if (deleted == null) {
            return false;
        }
        addressesDB.remove(deleted);
        return true;
    }

    public Set<Address> getAll() {
        return addressesDB;
    }
}

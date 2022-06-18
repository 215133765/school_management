package za.ac.cput.Services.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Address;
import za.ac.cput.Repository.impl.AddressRepository;
import za.ac.cput.Services.Interfaces.IAddressService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddressService implements IAddressService {

    private static AddressService service;
    private AddressRepository addressRepository;

    private AddressService() {this.addressRepository = AddressRepository.getRepository();}

    public static AddressService getService() {
        if (service == null) service = new AddressService();
        return service;
    }

    @Override
    public Address create(Address address) {return this.addressRepository.create(address);}

    @Override
    public Address read(String add) {return this.addressRepository.read(add);}


    @Override
    public Address update(Address address) {return this.addressRepository.update(address);}

    @Override
    public boolean delete(String s) {
        this.addressRepository.delete(s);
        return true;
    }
//    @Override
//    public List<Address> getAll() {
//        HashSet<Address> addresses = new HashSet<>(this.addressRepository.getAll());
//        return (List<Address>) addresses;
//    }
    @Override
    public Set<Address> getAll() {
        return this.addressRepository.getAll();
    }


}


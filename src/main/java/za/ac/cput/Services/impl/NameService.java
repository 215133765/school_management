package za.ac.cput.Services.impl;

import za.ac.cput.Domain.Name;
import za.ac.cput.Repository.Interfaces.INameRepository;
import za.ac.cput.Repository.impl.NameRepository;
import za.ac.cput.Services.Interfaces.INameService;

public class NameService implements INameService {

    private static INameService nameService;
    private INameRepository nameRepository;

    private NameService(){


        this.nameRepository = NameRepository.getNameRepository();

    }

    public static INameService getNameService(){
        if (nameService == null){
            nameService = new NameService();
        }
        return nameService;
    }

    @Override
    public Name create(Name name) {
        return this.nameRepository.create(name);
    }

    @Override
    public Name read(String s) {
        return this.nameRepository.read(s);
    }

    @Override
    public Name update(Name name) {
        return this.nameRepository.update(name);
    }

    @Override
    public boolean delete(String s) {

        this.nameRepository.delete(s);
        return false;
    }
}

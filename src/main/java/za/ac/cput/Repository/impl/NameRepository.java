

package za.ac.cput.Repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Name;
import za.ac.cput.Repository.Interfaces.INameRepository;

import java.util.HashSet;
import java.util.Set;

public class NameRepository implements INameRepository {

    private Set<Name> names;
    private static INameRepository nameRepository;

    private NameRepository(){
        this.names = new HashSet<>();
    }

    public static INameRepository getNameRepository(){
        if (nameRepository == null){
            nameRepository =  new NameRepository();
        }
        return nameRepository;
    }


    @Override
    public Name create(Name name) {

        this.names.add(name);

        return name;

    }

    @Override
    public Name read(String s) {

        Name name = this.names.stream().filter( e -> e.getLastName().equalsIgnoreCase(s)).findAny().orElse(null);

        return name;

    }

    @Override
    public Name update(Name name) {

        Name name1 = read(name.getMiddleName());

        if (name1 != null) {
            Name updated = new Name.Builder().copy(name1).setMiddleName(name.getMiddleName()).build();
            name1 = updated;
        }
        return name1;

    }

    @Override
    public void delete(String s) {

        Name name = read(s);
        this.names.remove(name);
    }

    public Set<Name> getAll() {

        return names;
    }
}
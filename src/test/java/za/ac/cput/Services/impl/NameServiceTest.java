package za.ac.cput.Services.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Name;
import za.ac.cput.Factory.NameFactory;
import za.ac.cput.Services.Interfaces.INameService;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {

    private static INameService service = NameService.getNameService();

    private static Name name = NameFactory.createName("Kanya", "West", "Ramncwana");

    private static Name name1 = NameFactory.createName("Mandisa", "Elizabeth", "Msongelwa");

    @Test
    void getNameService() {

        INameService nameService = NameService.getNameService();

    }

    @Test
    void create() {

        Name created;
        created = service.create(name1);
        assertEquals(name1.getFirstName(), created.getFirstName());
        assertEquals(name1.getMiddleName(), created.getMiddleName());
        assertEquals(name1.getLastName(), created.getLastName());
        System.out.println("Create: " + '\n' + created);

    }

    @Test
    void read() {

        Name read = service.read(name.getLastName());
        System.out.println("Read : " + '\n' + read);

    }

    @Test
    void update() {


        Name.Builder builder = new Name.Builder();
        builder.copy(name);
        builder.setLastName("Moathodi");
        Name updated = builder.build();
        System.out.println("Name Updated: "+updated);

    }

    @Test
    void delete() {

        boolean deleted = service.delete(name.getMiddleName());
        assertTrue(deleted);
        System.out.println("Delted" + deleted);

    }


}
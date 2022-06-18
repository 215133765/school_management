/*NameFactory.java
Factory for Name
Author: Kanya Ramncwana (218297521)
Date: 10 June 2022

Question 2A

 */

package za.ac.cput.Factory;

import za.ac.cput.Domain.Name;
import za.ac.cput.Utility.Helper;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName){

    if (Helper.isEmpty(firstName) || Helper.isEmpty(lastName))

        return null;

        return new Name.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();

    }
}

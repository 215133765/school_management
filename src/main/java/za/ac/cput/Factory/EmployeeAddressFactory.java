package za.ac.cput.Factory;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO EmployeeAddressFactory.java
 *  EmployeeAddress Factory file to be implemented
 * Created: 10/6/2022
 * */
import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.EmployeeAddress;
import za.ac.cput.Utility.Helper;

public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress(String staffId, Address address){

        if (Helper.isEmpty(staffId))
            return null;

        EmployeeAddress emploAddress = new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address)
                .build();

        return emploAddress;
    }
}

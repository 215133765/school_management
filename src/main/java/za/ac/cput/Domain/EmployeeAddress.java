package za.ac.cput.Domain;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO EmployeeAddress.java
 *  EmployeeAddress Entity file to be implemented
 * Created: 10/6/2022
 * */
public class EmployeeAddress {
    private String staffId;
    private Address address;

    //Constructor
    private EmployeeAddress(Builder builder){
        this.staffId = builder.staffId;
        this.address = builder.address;
    }

    //Getters and setters
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //toString
    @Override
    public String toString() {
        return "Employee :" +
                  staffId + '\n' +
                address ;
    }

    //Builder Pattern Class
    public static class Builder{
        private  String staffId;
        private Address address;

        public  Builder setStaffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress empAdd){
            this.staffId = empAdd.staffId;
            this.address = empAdd.address;

            return  this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }
}

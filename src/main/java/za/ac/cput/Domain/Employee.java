/*Employee.java
Domain for Employee
Author: Nikitha Mbokotwana (218337906)
Date: 10 June 2022
 */
package za.ac.cput.Domain;

public class Employee {
    private String staffId,email;
    private Name name;

    //private constructor
    private Employee(Builder builder) {
        this.email = builder.email;
        this.staffId = builder.staffId;
        this.name = builder.name;
    }
    //Getter and Setter of staffID
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    //Getter and Setter of email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Getter and Setter of name
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    //toString method
    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }
    //Builder pattern
    public static class Builder{
        private String staffId,email;
        private Name name;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }
        public Builder copy(Employee employee){
            this.email = employee.email;
            this.staffId = employee.staffId;
            this.name = employee.name;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
}

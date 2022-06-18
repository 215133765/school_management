/**
 * Employee.java
 * Author: Nikitha Mbokotwana
 * Question 1: Implemenation of Employee domain and value object package
 * Group: 28
 * Created: 10/6/2022
 * */
package za.ac.cput.Domain;
import java.util.Objects;

public class Employee {
    private String staffId, email;
    private Name name;

    //Constructor
    private Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    //Getters
    public String getStaffId() {
        return staffId;
    }
    public String getEmail() {
        return email;
    }
    public Name getName() {
        return name;
    }

    //toString
    @Override
    public String toString() {
        return "Employee: " + '\n' +
                "Staff ID: " + staffId + '\n' +
                "Full name: " + name  + '\n'+
                "Email: " + email ;
    }

    //Builder pattern
    public static class Builder {
        private String staffId;
        private String email;
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

        public Employee.Builder copy(Employee employee) {
            this.staffId = employee.staffId;
            this.email = employee.email;
            this.name = employee.name;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }

    //For compound attribute identifiers
    public static class EmployeeId{
        private String staffId, email;
        public EmployeeId(String staffId, String email) {
            this.staffId = staffId;
            this.email = email;
        }
        public String getStaffId() {
            return staffId;
        }
        public String getEmail() {
            return email;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeId that = (EmployeeId) o;
            return staffId.equals(that.staffId) && email.equals(that.email);
        }
        @Override
        public int hashCode() {
            return Objects.hash(staffId, email);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return staffId.equals(that.staffId) && email.equals(that.email);    }
    // Calculate hash code
    @Override
    public int hashCode() {
        return Objects.hash(staffId, email);
    }

}

/*Name.java
Domain for Name
Author: Kanya Ramncwana (218297521)
Date: 10 June 2022

Question 1

 */

package za.ac.cput.Domain;

public class Name {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Name (Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;

    }

    @Override
    public String toString() {
        return  firstName + ' ' +
                middleName + ' ' +
                lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public String getLastName() {

        return lastName;
    }

    public static class Builder {

        private String firstName, middleName, lastName;


        public Builder setFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }

        public Builder setMiddleName(String middleName) {

            this.middleName = middleName;

            return this;
        }

        public Builder setLastName(String lastName) {

            this.lastName = lastName;

            return this;
        }


        public Name build() {

            return new Name(this);

        }
        public Builder copy(Name name) {

            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;

            return this;
        }
    }
}

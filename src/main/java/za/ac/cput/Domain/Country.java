package za.ac.cput.Domain;
/**
 Country.java
 Domain: Country
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 June 2022
 */

public class Country {
    private String id, name;

    //Parameterized Constructor
    public Country(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    //No-Arg Constructor
    public Country(){

    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //toString
    @Override
    public String toString() {
        return name + ' ' + id  ;
    }

    //Builder Pattern Class
    public static class Builder {
        private String id, name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Country country) {
            this.id = country.id;
            this.name = country.name;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }
}

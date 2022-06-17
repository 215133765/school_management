package za.ac.cput.Domain;
/**
 * Author: Mziyanda Mwanda 215133765
 * POJO City.java
 *  City Entity file to be implemented
 * Created: 10/6/2022
 * */
public class City {
    public String cityId;
    private String cityName;
    private Country country;

   //Constructor
   private City(Builder builder){
      this.cityId = builder.cityId;
      this.cityName = builder.cityName;
      this.country = builder.country;
  }

  //Getters and Setters
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    //toString
    @Override
    public String toString() {
        return  cityId + ' ' + cityName +
                '\n'  + country ;
    }

    //Builder Pattern Class
    public static class Builder{
        private String cityId;
        private String cityName;
        private Country country;

        public Builder setCityId(String cityId){
            this.cityId = cityId;
            return this;
        }

        public  Builder setCityName(String cityName){
            this.cityName = cityName;
            return this;
        }

        public Builder setCountry(Country country){
            this.country = country;
            return this;
        }

        public Builder copy(City citi){
            this.cityId = citi.cityId;
            this.cityName = citi.cityName;
            this.country = citi.country;

            return this;
        }

        public City build(){
            return new City(this);

        }
    }
}

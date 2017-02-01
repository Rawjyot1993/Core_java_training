package com.java.Demo;

/**
 * Created by rawjyot on 1/25/17.
 */
public class Address {

    int street_no;
    String Name;
    int pincode;
    String city;
    String country;


    public static Address addAddress(int street_no,String name,int pincode,String city,String country)
    {
        Address local=new Address();
        local.setCity(city);
        local.setPincode(pincode);
        local.setStreet_no(street_no);
        local.setCountry(country);
        local.setName(name);

      return local;

    }


    public int getStreet_no() {
        return street_no;
    }

    public void setStreet_no(int street_no) {
        this.street_no = street_no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

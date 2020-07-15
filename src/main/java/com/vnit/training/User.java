package com.vnit.training;

public class User {
    String name, city;

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public User() {

    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}

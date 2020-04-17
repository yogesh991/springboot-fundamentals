package com.springboot.restservice.model;

import org.springframework.stereotype.Component;
/*
@Author : Yogesh Deshmukh
*/
@Component
public class UserDetail {

    private String firstName;
    private String lastName;
    private String city;

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

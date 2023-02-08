package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.outer.person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public Person() {}

    public String getInformation() {
        return String.format("Information: full name> %s %s, age> %d, address>%s",
                getFirstName(), getLastName(), getAge(), getAddress());
    }

    private String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

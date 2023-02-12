package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.outer.userdto;

//A product in builder pattern
public class UserWebDto implements UserDto {

    private String name;

    private String address;

    private String age;

    public UserWebDto(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nage=" + age + "\naddress=" + address ;
    }
}

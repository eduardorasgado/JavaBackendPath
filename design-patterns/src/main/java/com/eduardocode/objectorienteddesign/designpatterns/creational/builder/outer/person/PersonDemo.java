package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.outer.person;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setFirstName("Eduardo")
                .setLastName("Rasgado")
                .setAge(28)
                .setAddress("Av example #1234, Mexico City")
                .build();

        System.out.println(person.getInformation());
    }
}

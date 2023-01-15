package com.eduardocode.designpatterns.creational.builder.inner.person;

public class PersonDemo {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setFirstName("Eduardo")
                .setLastName("Rasgado")
                .setAge(28)
                .setAddress("Tokyo, Japan")
                .build();

        System.out.println(person.getInformation());
    }
}

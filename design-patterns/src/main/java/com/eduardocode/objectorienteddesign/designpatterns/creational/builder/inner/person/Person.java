package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.inner.person;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getInformation() {
        return String.format("Information: full name> %s %s, age> %d, address>%s",
                getFirstName(), getLastName(), getAge(), getAddress());
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private int getAge() {
        return age;
    }

    private String getAddress() {
        return address;
    }
}

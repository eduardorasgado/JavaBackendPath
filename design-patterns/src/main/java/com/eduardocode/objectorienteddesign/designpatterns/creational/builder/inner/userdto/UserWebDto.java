package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.inner.userdto;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//A product in builder pattern
public class UserWebDto {

    private String name;

    private String address;

    private String age;

    private UserWebDto() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nage=" + age + "\naddress=" + address ;
    }

    public static UserWebDtoBuilder newBuilder(StringFormatter<Address> addressFormatter) {
        return new UserWebDto().new UserWebDtoBuilder(addressFormatter);
    }

    public class UserWebDtoBuilder {

        private String firstName;
        private String lastName;

        private final StringFormatter<Address> stringFormatter;


        private UserWebDtoBuilder(StringFormatter<Address> stringFormatter) {
            this.stringFormatter = stringFormatter;
        }

        public UserWebDtoBuilder withFirstName(String fname) {
            firstName = fname;
            return this;
        }

        public UserWebDtoBuilder withLastName(String lname) {
            lastName = lname;
            return this;
        }

        public UserWebDtoBuilder withBirthday(LocalDate date) {
            Period ageInYears = Period.between(date, LocalDate.now(ZoneId.of("UTC-6")));
            UserWebDto.this.setAge(String.valueOf(ageInYears.getYears()));

            return this;
        }

        public UserWebDtoBuilder withAddress(Address address) {
            UserWebDto.this.setAddress(stringFormatter.get(address));
            return this;
        }

        public UserWebDto build() {
            UserWebDto.this.setName(firstName + " " + lastName);
            return UserWebDto.this;
        }
    }
}

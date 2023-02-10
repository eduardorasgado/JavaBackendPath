package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.userdto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//The concrete builder for UserWebDto
public class UserWebDtoBuilder implements UserDtoBuilder {

    private String firstName;
    private String lastName;
    private String age;
    private String address;

    private UserWebDto userDto;

    private final StringFormatter<Address> stringFormatter;

    public UserWebDtoBuilder(StringFormatter<Address> stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    @Override
    public UserDtoBuilder withFirstName(String fname) {
        firstName = fname;
        return this;
    }

    @Override
    public UserDtoBuilder withLastName(String lname) {
        lastName = lname;
        return this;
    }

    @Override
    public UserDtoBuilder withBirthday(LocalDate date) {
        Period ageInYears = Period.between(date, LocalDate.now(ZoneId.of("UTC-6")));
        age = String.valueOf(ageInYears.getYears());
        return this;
    }

    @Override
    public UserDtoBuilder withAddress(Address address) {
        this.address = stringFormatter.get(address);
        return this;
    }

    @Override
    public UserDto build() {
        userDto = new UserWebDto(firstName + " " + lastName, address, age);
        return userDto;
    }

    @Override
    public UserDto getUserDTO() {
        return userDto;
    }

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse("08-05-1994", formatter);
        Period ageInYears = Period.between(birthday, LocalDate.now(ZoneId.of("UTC-6")));
        System.out.println(ageInYears.getYears());
    }
}


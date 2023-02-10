package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.userdto;

import java.time.LocalDate;

//Abstract builder
public interface UserDtoBuilder {
    //methods to build "parts" of product at a time
    UserDtoBuilder withFirstName(String fname) ;

    UserDtoBuilder withLastName(String lname);

    UserDtoBuilder withBirthday(LocalDate date);

    UserDtoBuilder withAddress(Address address);
    //method to "assemble" final product
    UserDto build();
    //(optional) method to fetch already built object
    UserDto getUserDTO();
}
package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.userdto;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

    public static void main(String[] args) {
        User newUser = createUser();
        UserDtoBuilder builder = new UserWebDtoBuilder(new AddressStringFormatter())
                .withFirstName(newUser.getFirstName())
                .withLastName(newUser.getLastName())
                .withBirthday(newUser.getBirthday())
                .withAddress(newUser.getAddress());

        UserDto userDto = builder.build();
        System.out.println(userDto.toString());
    }

    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1960, 5, 6));
        user.setFirstName("Ron");
        user.setLastName("Swanson");
        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipcode("47998");
        user.setAddress(address);
        return user;
    }
}

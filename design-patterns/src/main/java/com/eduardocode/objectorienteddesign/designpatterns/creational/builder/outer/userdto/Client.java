package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.outer.userdto;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

    public static void main(String[] args) {
        User newUser = createUser();
        UserDtoBuilder builder = new UserWebDtoBuilder(new AddressStringFormatter());

        UserDto userDto = directBuild(builder, newUser);
        System.out.println(userDto.toString());
    }

    private static UserDto directBuild(UserDtoBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withBirthday(user.getBirthday())
                .withAddress(user.getAddress())
                .build();
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

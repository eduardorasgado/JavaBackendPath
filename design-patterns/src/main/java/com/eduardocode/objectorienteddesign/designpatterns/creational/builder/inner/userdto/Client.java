package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.inner.userdto;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

    public static void main(String[] args) {
        User newUser = createUser();

        UserWebDto userDto = directBuild(newUser);
        System.out.println(userDto.toString());
    }

    private static UserWebDto directBuild(User user) {
        return UserWebDto.newBuilder(new AddressStringFormatter())
                .withFirstName(user.getFirstName())
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

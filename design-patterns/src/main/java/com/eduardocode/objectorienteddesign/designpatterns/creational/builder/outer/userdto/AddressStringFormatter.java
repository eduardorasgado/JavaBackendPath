package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.outer.userdto;

public class AddressStringFormatter implements StringFormatter<Address> {

    public AddressStringFormatter() {}

    public String get(Address address) {
        return new StringBuilder()
                .append(address.getStreet())
                .append(" ")
                .append(address.getHouseNumber())
                .append(" ")
                .append(address.getCity())
                .append(" ")
                .append(address.getZipcode())
                .append(" ")
                .append(address.getState())
                .toString();
    }
}

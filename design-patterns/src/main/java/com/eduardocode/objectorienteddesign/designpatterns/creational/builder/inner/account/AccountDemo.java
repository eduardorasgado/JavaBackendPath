package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.inner.account;

public class AccountDemo {

    public static void main(String[] args) {
        Account account = Account.newBuilder()
                .setToken("hello")
                .setUserId("1232")
                .build();

        System.out.println(account);
    }
}

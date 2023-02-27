package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.errormessage;

public class ErrorMessageDemo {

    public static void main(String[] args) {

        ErrorMessageFactory errorMessageFactory = ErrorMessageFactory.getInstance();
        
        UserBannedError bannedError = new UserBannedError(errorMessageFactory.getError(ErrorType.SessionError), "1001");
        UserBannedError bannedError2 = new UserBannedError(errorMessageFactory.getError(ErrorType.SessionError), "1002");
        UserBannedError bannedError3 = new UserBannedError(errorMessageFactory.getError(ErrorType.SessionError), "1003");

        System.out.println(bannedError.getMessage());
        System.out.println(bannedError2.getMessage());
        System.out.println(bannedError3.getMessage());

        System.out.println(bannedError.getFlyweght().equals(bannedError2.getFlyweght()));
        System.out.println(bannedError.getFlyweght().equals(bannedError3.getFlyweght()));
    }
}

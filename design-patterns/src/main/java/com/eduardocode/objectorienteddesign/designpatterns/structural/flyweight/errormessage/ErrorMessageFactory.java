package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.errormessage;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessageFactory {

    private final Map<ErrorType, SystemErrorMessage> errorMessages;

    private static final ErrorMessageFactory FACTORY = new ErrorMessageFactory();

    private ErrorMessageFactory() {
        errorMessages = new HashMap<>();

        errorMessages.put(ErrorType.SessionError,
                new SystemErrorMessage(
                        "A session error of type ${errorCode} occurred. Please refer to: ",
                        "https://www.google.com/search?q=error"));

        errorMessages.put(ErrorType.PageNotFoundError,
                new SystemErrorMessage(
                        "Page Not Found error occurred, code: ${errorCode}. If you want to go deeper go to ",
                        "http://somedomain.com/help?error="));

        errorMessages.put(ErrorType.PageNotFoundError,
                new SystemErrorMessage(
                        "Server error occurred, code: ${errorCode}. Please refer to",
                        "http://developer.mozilla.com/error="));
    }

    public static ErrorMessageFactory getInstance() {
        return FACTORY;
    }

    public SystemErrorMessage getError(ErrorType type) {
        return errorMessages.get(type);
    }
}

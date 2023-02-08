package com.eduardocode.objectorienteddesign.designpatterns.solidprinciples.singleresponsability.before;

import java.io.IOException;

public class Main {

    //A valid USER JSON String
    private static final String VALID_USER_JSON = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";

    //Invalid USER JSON String - email format wrong
    private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";

    public static void main(String[] args) throws IOException {
        UserController controller = new UserController();

        String response = controller.createUser(VALID_USER_JSON);

        if(response.equalsIgnoreCase("SUCESS")) {
            System.err.println("FAILED");
        }

        System.out.println("Valid JSON received response: " + response);

        response = controller.createUser(INVALID_USER_JSON);

        if(!response.equalsIgnoreCase("ERROR")) {
            System.err.println("FAILED TO REJECT INVALID USER OBJECT");
        }

        System.out.println("Invalid JSON received response: " + response);
    }
}

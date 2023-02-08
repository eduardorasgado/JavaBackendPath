package com.eduardocode.designpatterns.solidprinciples.singleresponsability.after;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private final UserPersistence persistence;
    private final UserValidator validator;

    public UserController() {
        validator = new UserValidator();
        persistence = new UserPersistence();
    }

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        if(!validator.validateUser(user)) {
            return "ERROR";
        }

        persistence.persist(user);

        return "SUCCESS";
    }
}

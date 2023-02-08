package com.eduardocode.objectorienteddesign.designpatterns.solidprinciples.singleresponsability.after;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

    ObjectMapper mapper;

    public JsonMapper() {
        this.mapper = new ObjectMapper();
    }

    public User map(String userJson) throws JsonProcessingException {

        return mapper.readValue(userJson, User.class);
    }
}

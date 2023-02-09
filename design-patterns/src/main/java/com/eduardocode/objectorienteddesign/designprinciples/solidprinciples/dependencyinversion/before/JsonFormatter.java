package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonFormatter implements Formatter{

    public String format(Message message) throws FormatException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

            throw new FormatException(e);
        }
    }
}

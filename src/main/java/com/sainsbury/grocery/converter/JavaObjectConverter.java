package com.sainsbury.grocery.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converts passed java object to json representation.
 */
public final class JavaObjectConverter {

    public String convertAsString(Object source) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(source);
    }
}

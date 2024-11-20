package com.hiep.mart.config;

import com.fasterxml.jackson.core.JsonParser;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

import static java.util.Locale.ENGLISH;

@Slf4j
@Component
public class AppObjectMapper extends ObjectMapper {

    public AppObjectMapper() {
        super.registerModules(new JavaTimeModule());
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(DeserializationFeature.USE_LONG_FOR_INTS, true);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
    }

    public <T> T toPojo(String json, Class<T> input) {
        try {
            return readValue(json, input);
        } catch (JsonProcessingException e) {
            log.error("Error process this json to " + input.getSimpleName() + " :\n" + e.getMessage());
            throw new AppException(ErrorCode.JSON_INVALID, null, ENGLISH);
        }
    }
}
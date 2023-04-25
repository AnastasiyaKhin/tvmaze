package com.epam.tvmaze.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PeopleValidationUtil {
    public static boolean isValidPeopleApiResponse(String responseBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            if (!rootNode.isObject()) {
                log.info("Invalid JSON format. Expected an object, but got: {}", rootNode.toString());
                return false;
            }
            if (!rootNode.has("id") || !rootNode.has("url") || !rootNode.has("name")
                    || !rootNode.has("country") || !rootNode.has("birthday")
                    || !rootNode.has("deathday") || !rootNode.has("gender") || !rootNode.has("image")
                    || !rootNode.has("updated") || !rootNode.has("_links")) {
                log.info("Missing one or more required fields in the JSON object: {}", rootNode.toString());
                return false;
            }
            log.info("All required fields are present in the JSON object: {}", rootNode.toString());
        } catch (JsonProcessingException e) {
            log.error("Error while processing JSON: " + e.getMessage());
            return false;
        }
        return true;
    }
}
package com.epam.tvmaze.utils;

import com.epam.tvmaze.pojo.show.SearchResult;
import com.epam.tvmaze.pojo.show.TVShow;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class TVShowValidationUtils {
    public static List<TVShow> createTVShowList(String body) {
        ObjectMapper mapper = new ObjectMapper();
        List<TVShow> tvShowList = new ArrayList<>();
        try {
            List<SearchResult> searchResultList = mapper.readValue(body, new TypeReference<List<SearchResult>>() {
            });
            for (SearchResult searchResult : searchResultList) {
                TVShow tvShow = searchResult.getTvShow();
                if (tvShow != null && tvShow.getId() != 0) {
                    tvShowList.add(tvShow);
                } else {
                    log.warn("Unable to parse TVShow object: " + searchResult);
                }
            }
        } catch (JsonProcessingException e) {
            log.error("Error while processing JSON: " + e.getMessage());
        }
        log.info(String.format("TVShow list: %s", tvShowList));
        return tvShowList;
    }

    public static boolean isArrayOfShowsValid(String body) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(body);
            if (!rootNode.isArray()) {
                log.info("Invalid JSON format. Expected an array, but got: {}", rootNode.toString());
                return false;
            }
            for (JsonNode node : rootNode) {
                if (!node.has("show")) {
                    log.info("Missing 'show' field in JSON object: {}", node.toString());
                    return false;
                }
                JsonNode showNode = node.get("show");
                if (!showNode.has("id") || !showNode.has("url") || !showNode.has("name")
                        || !showNode.has("webChannel") || !showNode.has("_links")) {
                    log.info("Missing one or more required fields in 'show' object: {}", showNode.toString());
                    return false;
                }
                log.info("All required fields are present in 'show' object: {}", showNode.toString());
            }
        } catch (JsonProcessingException e) {
            log.error("Error while processing JSON: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidSingleSearchShowApiResponse(String responseBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            if (!rootNode.isObject()) {
                log.info("Invalid JSON format. Expected an object, but got: {}", rootNode.toString());
                return false;
            }
            if (!rootNode.has("id") || !rootNode.has("url") || !rootNode.has("name")
                    || !rootNode.has("webChannel") || !rootNode.has("_links")) {
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
package com.epam.tvmaze.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ShowSearchClient {
    private RestClient client;

    public ShowSearchClient() {
        client = new RestClient();
    }

    public Response getShowSearch(String tvShowPartOfName) {
        String showSearchPath = String.format("/search/shows?q=%s", tvShowPartOfName);
        log.info(String.format("Request: %s", showSearchPath));
        return client.sendGet(showSearchPath);
    }
}
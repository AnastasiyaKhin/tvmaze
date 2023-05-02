package com.epam.tvmaze.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SingleSearchClient {
    private RestClient client;

    public SingleSearchClient() {
        client = new RestClient();
    }

    public Response getSingleSearch(String tvShowName) {
        String singleSearchPath = String.format("/singlesearch/shows?q=%s", tvShowName);
        log.info(String.format("Request: %s", singleSearchPath));
        return client.sendGet(singleSearchPath);
    }
}
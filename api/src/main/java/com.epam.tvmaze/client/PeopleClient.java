package com.epam.tvmaze.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PeopleClient {
    private RestClient client;

    public PeopleClient() {
        client = new RestClient();
    }

    public Response getPeople(int personId) {
        String peoplePath = String.format("/people/%s", personId);
        log.info(String.format("Request: %s", peoplePath));
        return client.sendGet(peoplePath);
    }
}
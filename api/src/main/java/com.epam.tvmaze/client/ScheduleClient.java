package com.epam.tvmaze.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ScheduleClient {
    private RestClient client;

    public ScheduleClient() {
        client = new RestClient();
    }

    public Response getScheduleSearch(String date) {
        String showSchedulePath = String.format("/schedule?country=US&date=%s", date);
        log.info(String.format("Request: %s", showSchedulePath));
        return client.sendGet(showSchedulePath);
    }
}
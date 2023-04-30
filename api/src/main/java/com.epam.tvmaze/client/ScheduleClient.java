package com.epam.tvmaze.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ScheduleClient {
    public Response getScheduleSearch(String date) {
        String showSchedulePath = String.format("/schedule?country=US&date=%s", date);
        log.info(String.format("Request: %s", showSchedulePath));
        return RestAssured.given()
                .when()
                .get(showSchedulePath);
    }
}
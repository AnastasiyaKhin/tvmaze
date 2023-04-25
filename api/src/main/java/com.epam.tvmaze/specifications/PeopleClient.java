package com.epam.tvmaze.specifications;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PeopleClient {
    public Response getPeople(int personId) {
        String peoplePath = String.format("/people/%s", personId);
        log.info(String.format("Request: %s", peoplePath));
        return RestAssured.given()
                .when()
                .get(peoplePath);
    }
}
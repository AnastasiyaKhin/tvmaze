package com.epam.tvmaze.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EpisodeClient {
    public Response getEpisode(int showID, int season, int number) {
        String episodePath = String.format("/shows/%s/episodebynumber?season=%s&number=%s", showID, season, number);
        log.info(String.format("Request: %s", episodePath));
        return RestAssured.given()
                .when()
                .get(episodePath);
    }
}
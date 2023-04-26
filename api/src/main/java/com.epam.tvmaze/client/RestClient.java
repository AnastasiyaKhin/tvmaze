package com.epam.tvmaze.client;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RestClient {
    public RestClient() {
        RestAssured.baseURI = ConfigReader.getValue(ConfigEnum.API_URL);
    }

    public <T> T sendGetArray(String url, Class<T[]> asClass) {
        log.info(String.format("Request: %s", url));
        return RestAssured.given()
                .when()
                .get(url)
                .then()
                .extract()
                .as(asClass)[0];
    }

    public Response sendGet(String url) {
        return RestAssured.given()
                .when()
                .get(url);
    }

    public void closeClient() {
        RestAssured.reset();
    }
}
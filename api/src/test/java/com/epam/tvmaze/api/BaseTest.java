package com.epam.tvmaze.api;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public static void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder().setBaseUri(ConfigReader.getValue(ConfigEnum.API_URL)).build();
    }

    @AfterClass
    public static void tearDown() {
        RestAssured.reset();
    }
}
package com.epam.tvmaze.api;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;

public class BaseTest {
    @AfterClass
    public static void tearDown() {
        RestAssured.reset();
    }
}
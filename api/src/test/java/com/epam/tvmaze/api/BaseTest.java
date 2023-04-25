package com.epam.tvmaze.api;

import com.epam.tvmaze.specifications.RestClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static RestClient client;

    @BeforeClass
    public static void setUp() {
        client = new RestClient();
    }

    @AfterClass
    public static void tearDown() {
        client.closeClient();
    }
}
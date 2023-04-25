package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import org.testng.annotations.Test;

public class ActionsPeopleValidTest extends BaseTest {
    @Test(description = "API ActionsPeople test with valid data", dataProvider = "", dataProviderClass = ApiDataRequest.class)
    public void testGetPeople(String personNameAndSurname) {

    }
}
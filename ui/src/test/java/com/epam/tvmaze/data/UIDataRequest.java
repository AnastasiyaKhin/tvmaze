package com.epam.tvmaze.data;

import org.testng.annotations.DataProvider;

public class UIDataRequest {
    @DataProvider(name = "People with valid data")
    public static Object[][] provideValidPeopleNameAndSurname() {
        return new Object[][]{
                {"Katee Sackhoff"},
                {"Amy Acker"},
                {"Morena Baccarin"}
        };
    }
}
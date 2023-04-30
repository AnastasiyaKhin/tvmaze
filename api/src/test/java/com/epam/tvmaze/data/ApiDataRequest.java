package com.epam.tvmaze.data;

import com.epam.tvmaze.utils.RandomData;
import org.testng.annotations.DataProvider;

public class ApiDataRequest {
    @DataProvider(name = "partOfName")
    public static Object[][] providePartOfTVShowName() {
        return new Object[][]{{"Wednesday"}, {"Hamlet"}, {"Downtown"}};
    }

    @DataProvider(name = "tvShowNameValid")
    public static Object[] provideValidTVShowName() {
        return new Object[]{"Wednesday", "Walker", "Barry"};
    }

    @DataProvider(name = "tvShowNameIncorrect")
    public static Object[][] provideIncorrectTVShowName() {
        return new Object[][]{
                {" "},
                {RandomData.generateNumbers()},
                {RandomData.generateRandomStringLetters()},
                {RandomData.generateRandomStringLettersAndNumbers()}
        };
    }

    @DataProvider(name = "People with valid data")
    public static Object[][] provideValidPeopleNameAndSurname() {
        return new Object[][]{
                {"Katee Sackhoff"},
                {"Amy Acker"},
                {"Morena Baccarin"}
        };
    }

    @DataProvider(name = "calendarDateAndTVShowName")
    public static Object[][] provideDateAndName() {
        return new Object[][]{
                {"2022-05-25", "The Flash"},
                {"2022-04-07", "Walker"},
                {"2022-06-12", "Barry"}
        };
    }

    @DataProvider(name = "incorrectCalendarDate")
    public static Object[][] provideDate() {
        return new Object[][]{
                {" "},
                {"30025-01-05"},
                {"2023-13-01"},
                {"2022-05-42"}
        };
    }
}
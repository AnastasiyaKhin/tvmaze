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
}
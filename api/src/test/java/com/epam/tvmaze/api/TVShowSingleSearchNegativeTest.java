package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.specifications.SingleSearchClient;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSingleSearchNegativeTest extends BaseTest {
    private final String EXPECTED_RESULT = "null";
    @Test(description = "API SingleSearch test with incorrect data ", dataProvider = "tvShowNameIncorrect", dataProviderClass = ApiDataRequest.class)
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        Response singleSearch = new SingleSearchClient().getSingleSearch(tvShowName);

        assertThat(singleSearch.getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
        assertThat(singleSearch.getBody().asString()).isEqualTo(EXPECTED_RESULT);
    }
}
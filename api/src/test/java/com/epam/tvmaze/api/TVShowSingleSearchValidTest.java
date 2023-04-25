package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.SingleSearchClient;
import com.epam.tvmaze.specifications.TVShowValidationService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSingleSearchValidTest extends BaseTest {
    @Test(description = "API SingleSearch test with valid data ", dataProvider = "tvShowNameValid", dataProviderClass = ApiDataRequest.class)
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        Response singleSearch = new SingleSearchClient().getSingleSearch(tvShowName);

        TVShow tvShow = singleSearch.getBody().as(TVShow.class);

        assertThat(singleSearch.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        assertThat(tvShow.getName())
                .as("Response should contain TV show with name %s", tvShowName)
                .isEqualTo(tvShowName);

        TVShowValidationService tvShowValidationService = new TVShowValidationService();
        assertThat(tvShowValidationService.isValidSingleSearchShowApiResponse(singleSearch.getBody().asString()))
                .as("Response should be valid")
                .isTrue();
    }
}
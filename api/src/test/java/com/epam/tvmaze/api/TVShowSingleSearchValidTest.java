package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.TVShowValidationService;
import com.epam.tvmaze.utils.TVShowValidationUtils;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSingleSearchValidTest extends BaseTest {
    @Test(description = "API SingleSearch test with valid data ", dataProvider = "tvShowNameValid", dataProviderClass = ApiDataRequest.class)
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        String url = String.format("/singlesearch/shows?q=%s", tvShowName);
        client.sendGet(url);

        assertThat(client.getStatusCode()).isEqualTo(200);

        TVShow tvShow = TVShowValidationUtils.createTVShow(client.getBody());
        assertThat(tvShow.getName())
                .as("Response should contain TV show with name %s", tvShowName)
                .isEqualTo(tvShowName);

        TVShowValidationService tvShowValidationService = new TVShowValidationService(client);
        assertThat(tvShowValidationService.isValidSingleSearchShowApiResponse(client.getBody()))
                .as("Response should be valid").isTrue();
    }
}
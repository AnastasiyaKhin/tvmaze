package com.epam.tvmaze.api;

import com.epam.tvmaze.client.EpisodeClient;
import com.epam.tvmaze.client.SingleSearchClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.ApiValidationService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionsEpisodeValidTest extends BaseTest {
    @Test(dataProvider = "tvShowNameValid", dataProviderClass = ApiDataRequest.class)
    public void testEpisodeActions(String tvShowName) {
        Response singleSearch = new SingleSearchClient().getSingleSearch(tvShowName);

        TVShow tvShow = singleSearch.getBody().as(TVShow.class);
        int showID = tvShow.getId();

        Response episodeByNumber = new EpisodeClient().getEpisode(showID, 1, 1);

        assertThat(episodeByNumber.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        ApiValidationService apiValidationService = new ApiValidationService();

        assertThat(apiValidationService.isValidEpisodeApiResponse(episodeByNumber.getBody().asString()))
                .as("Response should be valid").isTrue();
    }
}
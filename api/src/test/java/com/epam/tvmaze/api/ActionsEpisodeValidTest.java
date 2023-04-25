package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.EpisodeClient;
import com.epam.tvmaze.specifications.SingleSearchClient;
import com.epam.tvmaze.specifications.TVShowValidationService;
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

        TVShowValidationService tvShowValidationService = new TVShowValidationService();

        assertThat(tvShowValidationService.isValidEpisodeApiResponse(episodeByNumber.getBody().asString()))
                .as("Response should be valid").isTrue();
    }
}
package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.EpisodeClient;
import com.epam.tvmaze.specifications.SingleSearchClient;
import com.epam.tvmaze.utils.RandomData;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionEpisodeNegativeTest extends BaseTest {
    private final String EXPECTED_RESPONSE = "{\"name\":\"Not Found\",\"message\":\"Unknown episode\",\"code\":0,\"status\":404}";

    @Test(dataProvider = "tvShowNameValid", dataProviderClass = ApiDataRequest.class)
    public void testEpisodeActions(String tvShowName) {
        Response singleSearch = new SingleSearchClient().getSingleSearch(tvShowName);
        TVShow tvShow = singleSearch.getBody().as(TVShow.class);
        int showID = tvShow.getId();
        int incorrectEpisodeID = Integer.parseInt(RandomData.generateNumbers());

        Response episodeByNumber = new EpisodeClient().getEpisode(showID, 1, incorrectEpisodeID);

        assertThat(episodeByNumber.getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);

        assertThat(episodeByNumber.getBody().asString()).isEqualTo(EXPECTED_RESPONSE);
    }
}
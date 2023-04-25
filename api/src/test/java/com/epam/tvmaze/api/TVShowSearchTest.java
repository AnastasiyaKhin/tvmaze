package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.specifications.ShowSearchClient;
import com.epam.tvmaze.specifications.TVShowValidationService;
import com.epam.tvmaze.utils.TVShowValidationUtils;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class TVShowSearchTest extends BaseTest {
    @Test(description = "API Search test with part of show name", dataProvider = "partOfName", dataProviderClass = ApiDataRequest.class)
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        Response showSearchClient = new ShowSearchClient().getShowSearch(tvShowPartOfName);

        assertThat(showSearchClient.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        TVShowValidationUtils tvShowValidationUtils = new TVShowValidationUtils();
        List<TVShow> tvShowList = tvShowValidationUtils.createTVShowList(showSearchClient.getBody().asString());

        assertThat(tvShowList)
                .filteredOn(tvShow -> tvShow.getName().contains(tvShowPartOfName))
                .as("Response should contain TV show with name %s", tvShowPartOfName)
                .isNotEmpty();

        TVShowValidationService tvShowValidationService = new TVShowValidationService();

        assertThat(tvShowValidationService.isArrayOfShowsValid(showSearchClient.getBody().asString()))
                .as("Response should be valid")
                .isTrue();
    }
}
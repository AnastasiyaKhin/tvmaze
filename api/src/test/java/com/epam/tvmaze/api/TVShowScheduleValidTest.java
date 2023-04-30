package com.epam.tvmaze.api;

import com.epam.tvmaze.client.ScheduleClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.show.TVShow;
import com.epam.tvmaze.utils.TVShowValidationUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowScheduleValidTest extends BaseTest {
    @Test(description = "API Calendar test", dataProvider = "calendarDateAndTVShowName",
            dataProviderClass = ApiDataRequest.class)
    public void testGetResponseContainsShowOnDate(String date, String tvShowName) {
        Response scheduleClient = new ScheduleClient().getScheduleSearch(date);

        assertThat(scheduleClient.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        TVShowValidationUtils tvShowValidationUtils = new TVShowValidationUtils();
        List<TVShow> tvShowList = tvShowValidationUtils.createTVShowList(scheduleClient.getBody().asString());

        assertThat(tvShowList)
                .filteredOn(tvShow -> tvShow.getName().contains(tvShowName))
                .as("Response should contain TV show with name %s", tvShowName)
                .isNotEmpty();
    }
}
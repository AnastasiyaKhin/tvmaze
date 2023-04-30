package com.epam.tvmaze.api;

import com.epam.tvmaze.client.ScheduleClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.response.ResponseNotFound;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowScheduleNegativeTest extends BaseTest {
    private final ResponseNotFound EXPECTED_RESPONSE = new ResponseNotFound("Unprocessable entity", "Not a valid ISO date", 0, 422);

    @Test(description = "API Calendar test with incorrect date", dataProvider = "incorrectCalendarDate",
            dataProviderClass = ApiDataRequest.class)
    public void testGetResponseContainsShowOnDate(String date) {
        Response scheduleClient = new ScheduleClient().getScheduleSearch(date);

        assertThat(scheduleClient.getStatusCode()).isEqualTo(HttpStatus.SC_UNPROCESSABLE_ENTITY);

        assertThat((scheduleClient.getBody()).as(ResponseNotFound.class))
                .isEqualTo(EXPECTED_RESPONSE);
    }
}
package com.epam.tvmaze.api;

import com.epam.tvmaze.pojo.response.ResponseNotFound;
import com.epam.tvmaze.specifications.PeopleClient;
import com.epam.tvmaze.utils.RandomData;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionPeopleNegativeTest extends BaseTest {
    private final ResponseNotFound EXPECTED_RESPONSE = new ResponseNotFound("Not Found", "", 0, 404);

    @Test()
    public void testGetPeople() {
        int personId = Integer.parseInt(RandomData.generateNumbers());

        Response peopleById = new PeopleClient().getPeople(personId);

        assertThat(peopleById.getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);

        assertThat(peopleById.getBody().as(ResponseNotFound.class))
                .isEqualTo(EXPECTED_RESPONSE);
    }
}
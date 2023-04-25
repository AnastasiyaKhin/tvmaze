package com.epam.tvmaze.api;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.person.Person;
import com.epam.tvmaze.specifications.PeopleClient;
import com.epam.tvmaze.specifications.PersonAPIHandler;
import com.epam.tvmaze.specifications.TVShowValidationService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionPeopleValidTest extends BaseTest {
    @Test(description = "API ActionsPeople test with valid data", dataProvider = "People with valid data",
            dataProviderClass = ApiDataRequest.class)
    public void testGetPeople(String peopleNameAndSurname) {
        PersonAPIHandler personAPIHandler = new PersonAPIHandler();
        Person apiPerson = personAPIHandler.getAPIPerson(peopleNameAndSurname);
        int personId = apiPerson.getId();

        Response peopleById = new PeopleClient().getPeople(personId);
        assertThat(peopleById.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

        TVShowValidationService tvShowValidationService = new TVShowValidationService();
        assertThat(tvShowValidationService.isValidPeopleApiResponse(peopleById.getBody().asString()))
                .as("Response should be valid").isTrue();
    }
}
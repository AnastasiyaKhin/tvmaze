package com.epam.tvmaze.specifications;

import com.epam.tvmaze.client.RestClient;
import com.epam.tvmaze.pojo.person.Person;
import com.epam.tvmaze.pojo.person.SearchPeople;

public class PersonAPIHandler {
    private RestClient client;

    public PersonAPIHandler() {
        client = new RestClient();
    }
    public Person getAPIPerson(String personNameAndSurname) {
        String url = String.format("/search/people?q=%s", personNameAndSurname);
        SearchPeople searchPeople = client.sendGetArray(url, SearchPeople[].class);
        return searchPeople != null ? searchPeople.getPerson() : null;
    }
}
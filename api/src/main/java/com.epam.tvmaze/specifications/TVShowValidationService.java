package com.epam.tvmaze.specifications;

import com.epam.tvmaze.utils.EpisodeValidationUtil;
import com.epam.tvmaze.utils.PeopleValidationUtil;
import com.epam.tvmaze.utils.TVShowValidationUtils;

public class TVShowValidationService {
    public boolean isArrayOfShowsValid(String body) {
        return TVShowValidationUtils.isArrayOfShowsValid(body);
    }

    public boolean isValidSingleSearchShowApiResponse(String responseBody) {
        return TVShowValidationUtils.isValidSingleSearchShowApiResponse(responseBody);
    }

    public boolean isValidEpisodeApiResponse(String responseBody) {
        return EpisodeValidationUtil.isValidEpisodeApiResponse(responseBody);
    }

    public boolean isValidPeopleApiResponse(String responseBody) {
        return PeopleValidationUtil.isValidPeopleApiResponse(responseBody);
    }
}
package com.epam.tvmaze.specifications;

import com.epam.tvmaze.utils.TVShowValidationUtils;

public class TVShowValidationService {
    public boolean isArrayOfShowsValid(String body) {
        return TVShowValidationUtils.isArrayOfShowsValid(body);
    }

    public boolean isValidSingleSearchShowApiResponse(String responseBody) {
        return TVShowValidationUtils.isValidSingleSearchShowApiResponse(responseBody);
    }
}

package com.epam.tvmaze.pojo.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Person {
    private int id;
    private String url;
    private String name;
    private Country country;
    private String birthday;
    private String gender;
}
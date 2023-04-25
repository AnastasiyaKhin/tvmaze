package com.epam.tvmaze.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseNotFound {
    private String name;
    private String message;
    private int code;
    private int status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseNotFound)) return false;
        ResponseNotFound that = (ResponseNotFound) o;
        return getCode() == that.getCode() &&
                getStatus() == that.getStatus() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getMessage(), that.getMessage());
    }
}
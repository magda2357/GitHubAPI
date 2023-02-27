package com.restApi.foreignApi.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientDtoRequest {

    @JsonProperty("full_name")
    private String fullName;

    private String description;

    @JsonProperty("clone_url")
    private String cloneUrl;

    @JsonProperty("stargazers_count")
    private int stargazersCount;

    @JsonProperty("created_at")
    private LocalDate createdAt;
}

package com.restApi.foreignApi.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class RepoDtoResponse {

    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars;
    private LocalDate createdAt;
}

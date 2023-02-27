package com.restApi.foreignApi.service;

import com.restApi.foreignApi.client.ClientDtoRequest;
import com.restApi.foreignApi.client.RepoClient;
import com.restApi.foreignApi.dto.RepoDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepoService {
    private final RepoClient repoClient;

    public RepoDtoResponse getRepository(String owner, String repo) {
        return getRepoDto(repoClient.getRepo(owner, repo));
    }

    private RepoDtoResponse getRepoDto(ClientDtoRequest clientDtoRequest) {
        return RepoDtoResponse.builder()
                .fullName(clientDtoRequest.getFullName())
                .description(clientDtoRequest.getDescription())
                .cloneUrl(clientDtoRequest.getCloneUrl())
                .stars(clientDtoRequest.getStargazersCount())
                .createdAt(clientDtoRequest.getCreatedAt())
                .build();
    }

}

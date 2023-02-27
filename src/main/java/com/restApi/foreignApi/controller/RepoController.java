package com.restApi.foreignApi.controller;

import com.restApi.foreignApi.dto.RepoDtoResponse;
import com.restApi.foreignApi.service.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repos")
@RequiredArgsConstructor
public class RepoController {

    private final RepoService repoService;

    @GetMapping("/{owner}/{repo}")
    public RepoDtoResponse getRepository(@PathVariable String owner, @PathVariable String repo) {
        return repoService.getRepository(owner, repo);
    }
}


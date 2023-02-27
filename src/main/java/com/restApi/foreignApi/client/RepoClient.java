package com.restApi.foreignApi.client;

import com.restApi.foreignApi.exception.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "github", url = "https://api.github.com/", configuration = {CustomErrorDecoder.class})
public interface RepoClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/repos/{owner}/{repo}",
            produces = "application/json")
    ClientDtoRequest getRepo(@PathVariable("owner") String owner, @PathVariable("repo") String repo);

}


package com.restApi.foreignApi.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Wrong request");
            case 404:
                return new RepositoryNotFoundException();
            case 503:
                return new RepositoryServiceNotAvailableException("Repo Api is unavailable");
            default:
                return new Exception("General exception while getting repository details");
        }
    }
}

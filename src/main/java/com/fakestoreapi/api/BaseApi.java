package com.fakestoreapi.api;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseApi {

    protected Response logAndValidateResponse(Response response, int statusCode) {
        log.info("Status code {}, Body: {}",
                response.getStatusCode(),
                response.asPrettyString());

        try {
            return response
                    .then()
                    .statusCode(statusCode)
                    .extract()
                    .response();
        } catch (AssertionError error) {
            log.error("Expected status code {}, but got {}. Full response: {}",
                    statusCode,
                    response.getStatusCode(),
                    response.asPrettyString());
            throw error;
        }
    }
}

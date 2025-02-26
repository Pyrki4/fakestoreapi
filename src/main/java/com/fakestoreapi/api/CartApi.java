package com.fakestoreapi.api;

import io.restassured.response.Response;

import static com.fakestoreapi.helpers.EndPoints.CARTS;
import static com.fakestoreapi.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class CartApi extends BaseApi {

    public Response getAll(int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get(CARTS);

        return logAndValidateResponse(response, statusCode);
    }

    public Response getById(int statusCode, int cartId) {
        Response response = given()
                .spec(requestSpecification())
                .get(CARTS + cartId);

        return logAndValidateResponse(response, statusCode);
    }

    public Response getWithLimit(int statusCode, int limit) {
        Response response = given()
                .spec(requestSpecification())
                .queryParam("limit", limit)
                .get(CARTS);

        return logAndValidateResponse(response, statusCode);
    }
}

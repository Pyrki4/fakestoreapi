package com.fakestoreapi.api;

import io.restassured.response.Response;

import static com.fakestoreapi.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class CartApi extends BaseApi {

    public Response getAllCarts(int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get("/carts");

        return logAndValidateResponse(response, statusCode);
    }
}

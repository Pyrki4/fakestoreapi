package com.fakestoreapi.api;

import com.fakestoreapi.helpers.EndPoints;
import io.restassured.response.Response;

import static com.fakestoreapi.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class ProductApi extends BaseApi {

    public Response getAll(int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get(EndPoints.PRODUCTS);

        return logAndValidateResponse(response, statusCode);
    }
    public Response getWithLimit(int statusCode, int limit) {
        Response response = given()
                .spec(requestSpecification())
                .queryParam("limit",limit)
                .get(EndPoints.PRODUCTS);

        return logAndValidateResponse(response, statusCode);
    }

    public Response getById(int productId, int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get(EndPoints.PRODUCTS + productId);

        return logAndValidateResponse(response, statusCode);
    }
}

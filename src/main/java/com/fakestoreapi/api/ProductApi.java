package com.fakestoreapi.api;

import com.fakestoreapi.helpers.EndPoints;
import io.restassured.response.Response;

import static com.fakestoreapi.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class ProductApi extends BaseApi {

    public Response getAllProducts(int statusCode) {
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

    public Response getWithSort(String sort, int statusCode){
        Response response = given()
                .spec(requestSpecification())
                .queryParam("sort", sort)
                .get(EndPoints.PRODUCTS);

        return logAndValidateResponse(response, statusCode);
    }

    public Response getById(int productId, int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get(EndPoints.PRODUCTS + productId);

        return logAndValidateResponse(response, statusCode);
    }

    public Response getAllCategories(int statusCode) {
        Response response = given()
                .spec(requestSpecification())
                .get(EndPoints.PRODUCTS + "categories");

        return logAndValidateResponse(response, statusCode);
    }

    public Response getWithCategory(String category, int statusCode){
        Response response = given()
                .spec(requestSpecification())
                .get(EndPoints.PRODUCTS + "category/" + category);

        return logAndValidateResponse(response, statusCode);
    }
}

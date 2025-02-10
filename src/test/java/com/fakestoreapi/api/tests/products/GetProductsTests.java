package com.fakestoreapi.api.tests.products;

import com.fakestoreapi.config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetProductsTests {

    private final TestConfig config = ConfigFactory.create(TestConfig.class);

    @Test
    void getAllProducts() {
        given()
                .basePath(config.baseUrl())
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }
}

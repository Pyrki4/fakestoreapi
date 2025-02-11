package com.fakestoreapi.steps;

import com.fakestoreapi.api.ProductApi;
import com.fakestoreapi.products.dto.ProductDto;

import java.util.List;

public class ProductsSteps {

    ProductApi productApi = new ProductApi();

    public List<ProductDto> getAllProducts(int statusCode) {
        return productApi.get(statusCode).body().jsonPath().getList("", ProductDto.class);
    }

    public ProductDto getProduct(int productId, int statusCode) {
        return productApi.post(productId, statusCode).then().extract().as(ProductDto.class);
    }
}

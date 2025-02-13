package com.fakestoreapi.steps;

import com.fakestoreapi.api.ProductApi;
import com.fakestoreapi.products.dto.ProductDto;

import java.util.List;

public class ProductsSteps {

    ProductApi productApi = new ProductApi();

    public List<ProductDto> getAllProducts(int statusCode) {
        return productApi.getAllProducts(statusCode).body().jsonPath().getList("", ProductDto.class);
    }

    public ProductDto getProductById(int productId, int statusCode) {
        return productApi.getById(productId, statusCode).then().extract().as(ProductDto.class);
    }

    public List<ProductDto> getProductsWithLimit(int statusCode, int limit) {
        return productApi.getWithLimit(statusCode, limit).jsonPath().getList("", ProductDto.class);
    }

    public List<ProductDto> getSortedProducts(int statusCode, String sort) {
        return productApi.getWithSort(sort, statusCode).jsonPath().getList("", ProductDto.class);
    }

    public List<String> getAllCategories(int statusCode) {
        return productApi.getAllCategories(statusCode).jsonPath().getList("", String.class);
    }

    public List<ProductDto> getProductsWithCategory(int statusCode, String category) {
        return productApi.getWithCategory(category, statusCode).jsonPath().getList("", ProductDto.class);
    }
}

package com.fakestoreapi.api.tests.products;

import com.fakestoreapi.api.tests.base.BaseTest;
import com.fakestoreapi.products.assertions.ProductAssertions;
import com.fakestoreapi.products.dto.CreateProductDto;
import com.fakestoreapi.products.dto.ProductDto;
import com.fakestoreapi.steps.ProductsSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductsTests extends BaseTest {

    ProductsSteps client = new ProductsSteps();

    @Test
    @DisplayName("shouldReturnAllProducts")
    void shouldReturnAllProducts() {
        List<ProductDto> products = client.getAllProducts(200);
        ProductAssertions.assertProductsFieldsNotEmpty(products);
    }

    @Test
    @DisplayName("shouldReturnSingleProductById")
    void shouldReturnSingleProductById() {
        int id = 1;
        ProductDto product = client.getProductById(id, 200);
        ProductAssertions.assertProductFieldsNotNull(product);
    }

    @Test
    @DisplayName("shouldReturnLimitedCountOfProducts")
    void shouldReturnLimitedCountOfProducts() {
        int limit = 1;
        List<ProductDto> products = client.getProductsWithLimit(200, limit);
        ProductAssertions.assertProductsMatchLimit(products, limit);
    }

    @Test
    @DisplayName("shouldReturnSortedProducts")
    void shouldReturnSortedProducts() {
        String sort = "desc";
        List<ProductDto> products = client.getSortedProducts(200, sort);
        ProductAssertions.assertProductIdsSorted(products, sort);
    }

    @Test
    @DisplayName("shouldReturnAllCategories")
    void shouldReturnAllCategories() {
        List<String> expectedCategories = new ArrayList<>(
                List.of("jewelery",
                        "electronics",
                        "men's clothing",
                        "women's clothing"));
        List<String> actualCategories = client.getAllCategories(200);
        ProductAssertions.assertExpectedCategories(expectedCategories, actualCategories);
    }

    @Test
    @DisplayName("shouldReturnProductsWithCategory")
    void shouldReturnProductsWithCategory() {
        String category = "electronics";
        List<ProductDto> products = client.getProductsWithCategory(200, category);
        ProductAssertions.assertProductsInCategory(products, category);
    }

    @Test
    @DisplayName("shouldCreateNewProduct")
    void shouldCreateNewProduct() {
        CreateProductDto product = new CreateProductDto("title", 10.5, "category", "description", "image");


//                title: 'test product',
//                price: 13.5,
//                description: 'lorem ipsum set',
//                image: 'https://i.pravatar.cc',
//                category: 'electronic'
    }
}

package com.fakestoreapi.api.tests.products;

import com.fakestoreapi.api.tests.base.BaseTest;
import com.fakestoreapi.products.assertions.ProductAssertions;
import com.fakestoreapi.products.dto.ProductDto;
import com.fakestoreapi.steps.ProductsSteps;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductsTests extends BaseTest {

    ProductsSteps client = new ProductsSteps();

    @Test
    void shouldReturnAllProductsWithoutDuplicates() {
        List<ProductDto> products = client.getAllProducts(200);
        ProductAssertions.assertProductsNotEmptyAndUnique(products);
    }

    @Test
    void shouldReturnSingleProductById() {
        ProductDto product = client.getProductById(1, 200);
        ProductAssertions.assertProductFieldsNotNull(product);
    }

    @Test
    void shouldReturnLimitedCountOfProducts() {
        int limit = 1;
        List<ProductDto> products = client.getProductsWithLimit(200, limit);
        ProductAssertions.assertProductsMatchLimit(products, limit);
    }
}

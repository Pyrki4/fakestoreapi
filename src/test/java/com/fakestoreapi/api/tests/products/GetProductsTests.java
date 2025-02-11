package com.fakestoreapi.api.tests.products;

import com.fakestoreapi.api.tests.base.BaseTest;
import com.fakestoreapi.products.assertions.ProductAssertions;
import com.fakestoreapi.products.dto.ProductDto;
import com.fakestoreapi.steps.ProductsSteps;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GetProductsTests extends BaseTest {

    ProductsSteps client = new ProductsSteps();

    @Test
    void getAllProducts() {
        List<ProductDto> products = client.getAllProducts(200);
        ProductAssertions.assertGetAllProducts(products);
    }

    @Test
    void getSingleProduct() {
        ProductDto product = client.getProduct(1,200);
    }
}

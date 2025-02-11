package com.fakestoreapi.products.assertions;

import com.fakestoreapi.products.dto.ProductDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductAssertions {
    public static void assertGetAllProducts(List<ProductDto> products) {
        assertThat(products).isNotEmpty();
        assertThat(products)
                .extracting(ProductDto::getId)
                .doesNotHaveDuplicates();
    }
}

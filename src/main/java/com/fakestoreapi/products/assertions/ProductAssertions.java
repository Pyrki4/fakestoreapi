package com.fakestoreapi.products.assertions;

import com.fakestoreapi.products.dto.ProductDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductAssertions {
    public static void assertProductsNotEmptyAndUnique(List<ProductDto> products) {
        assertThat(products).isNotEmpty();
        assertThat(products)
                .extracting(ProductDto::getId)
                .doesNotHaveDuplicates();
    }

    public static void assertProductFieldsNotNull(ProductDto product) {
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getTitle()).isNotNull();
        assertThat(product.getPrice()).isNotNull();
        assertThat(product.getCategory()).isNotNull();
        assertThat(product.getDescription()).isNotNull();
        assertThat(product.getImage()).isNotNull();

        assertThat(product.getRating()).isNotNull();
        assertThat(product.getRating().getRate()).isNotNull();
        assertThat(product.getRating().getCount()).isNotNull();
    }

    public static void assertProductsMatchLimit(List<ProductDto> products, int limit) {
        assertThat(products).hasSize(limit);
    }
}

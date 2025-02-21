package com.fakestoreapi.products.assertions;

import com.fakestoreapi.products.dto.CreateProductDto;
import com.fakestoreapi.products.dto.NewProductDto;
import com.fakestoreapi.products.dto.ProductDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductAssertions {
    public static void assertProductsFieldsNotEmpty(List<ProductDto> products) {
        assertThat(products).isNotEmpty();
        for (ProductDto product : products) {
            assertThat(product.getId()).isNotEqualTo(0);
            assertThat(product.getTitle()).isNotNull();
            assertThat(product.getPrice()).isNotEqualTo(0);
            assertThat(product.getCategory()).isNotNull();
            assertThat(product.getDescription()).isNotNull();
            assertThat(product.getImage()).isNotNull();

            assertThat(product.getRating()).isNotNull();
            assertThat(product.getRating().getRate()).isNotEqualTo(0);
            assertThat(product.getRating().getCount()).isNotEqualTo(0);
        }
    }

    public static void assertProductFieldsNotNull(ProductDto product) {
        assertThat(product).isNotNull();

        assertThat(product.getId()).isNotEqualTo(0);
        assertThat(product.getTitle()).isNotNull();
        assertThat(product.getPrice()).isNotEqualTo(0);
        assertThat(product.getCategory()).isNotNull();
        assertThat(product.getDescription()).isNotNull();
        assertThat(product.getImage()).isNotNull();

        assertThat(product.getRating()).isNotNull();
        assertThat(product.getRating().getRate()).isNotEqualTo(0);
        assertThat(product.getRating().getCount()).isNotEqualTo(0);
    }

    public static void assertProductsMatchLimit(List<ProductDto> products, int limit) {
        assertThat(products).hasSize(limit);
    }

    public static void assertProductIdsSorted(List<ProductDto> products, String sort) {
        List<Integer> actualIds = products.stream()
                .map(ProductDto::getId)
                .toList();

        List<Integer> expectedIds = new ArrayList<>(actualIds);

        if ("asc".equalsIgnoreCase(sort)) {
            expectedIds.sort(Comparator.naturalOrder());
        } else if ("desc".equalsIgnoreCase(sort)) {
            expectedIds.sort(Comparator.reverseOrder());
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + sort);
        }

        assertThat(actualIds).isEqualTo(expectedIds);
    }

    public static void assertExpectedCategories(List<String> expected, List<String> actual) {
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    public static void assertProductsInCategory(List<ProductDto> products, String category) {
        assertThat(products)
                .extracting(ProductDto::getCategory)
                .containsOnly(category);
    }

    public static void assertNewProductFields(CreateProductDto expectedProduct, NewProductDto actualProduct) {
        assertThat(actualProduct.getTitle()).isEqualTo(expectedProduct.getTitle());
        assertThat(actualProduct.getDescription()).isEqualTo(expectedProduct.getDescription());
        assertThat(actualProduct.getCategory()).isEqualTo(expectedProduct.getCategory());
        assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
        assertThat(actualProduct.getImage()).isEqualTo(expectedProduct.getImage());
    }

    public static void assertProductFields(ProductDto expectedProduct, ProductDto actualProduct) {
        assertThat(actualProduct.getId()).isEqualTo(expectedProduct.getId());
        assertThat(actualProduct.getTitle()).isEqualTo(expectedProduct.getTitle());
        assertThat(actualProduct.getDescription()).isEqualTo(expectedProduct.getDescription());
        assertThat(actualProduct.getCategory()).isEqualTo(expectedProduct.getCategory());
        assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
        assertThat(actualProduct.getImage()).isEqualTo(expectedProduct.getImage());
        assertThat(actualProduct.getRating().getRate()).isEqualTo(expectedProduct.getRating().getRate());
        assertThat(actualProduct.getRating().getCount()).isEqualTo(expectedProduct.getRating().getCount());
    }
}

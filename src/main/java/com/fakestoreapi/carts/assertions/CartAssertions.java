package com.fakestoreapi.carts.assertions;

import com.fakestoreapi.carts.dto.CartDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartAssertions {
    public static void assertCartFieldsNotEmpty(List<CartDto> carts) {
        assertThat(carts).isNotEmpty();
        for (CartDto cart : carts) {
            assertThat(cart.getId()).isNotEqualTo(0);
            assertThat(cart.getUserId()).isNotEqualTo(0);
            assertThat(cart.getDate()).isNotNull();
            for (CartDto.Products product : cart.getProducts()) {
                assertThat(product.getProductId()).isNotEqualTo(0);
                assertThat(product.getQuantity()).isNotEqualTo(0);
            }
        }
    }
}

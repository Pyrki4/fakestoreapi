package com.fakestoreapi.tests.api.carts;

import com.fakestoreapi.carts.assertions.CartAssertions;
import com.fakestoreapi.carts.dto.CartDto;
import com.fakestoreapi.carts.steps.CartSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class CartsTests {

    CartSteps client = new CartSteps();

    @Test
    @DisplayName("shouldReturnAllCarts")
    void shouldReturnAllCarts() {
        List<CartDto> carts = client.getAllCarts(SC_OK);
        CartAssertions.assertCartsFieldsNotEmpty(carts);
    }

    @Test
    @DisplayName("shouldReturnSingleCartById")
    void shouldReturnSingleCartById() {
        CartDto expectedCart = new CartDto(7, 8, "2020-03-01T00:00:00.000Z", new CartDto.Products[]{new CartDto.Products(18, 1)}, "0");
        CartDto actualCart = client.getCartById(SC_OK, expectedCart.getId());
        CartAssertions.assertCartFields(expectedCart, actualCart);
    }

    @Test
    @DisplayName("shouldReturnLimitedCountOfCarts")
    void shouldReturnLimitedCountOfCarts() {
        int limit = 5;
        List<CartDto> carts = client.getCartsWithLimit(SC_OK, limit);
        CartAssertions.assertCartsWithLimit(carts, limit);
    }
}

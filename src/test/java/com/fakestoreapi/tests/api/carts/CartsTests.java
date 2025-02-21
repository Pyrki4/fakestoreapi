package com.fakestoreapi.tests.api.carts;

import com.fakestoreapi.carts.assertions.CartAssertions;
import com.fakestoreapi.carts.dto.CartDto;
import com.fakestoreapi.carts.steps.CartSteps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.apache.http.HttpStatus.*;

public class CartsTests {

    CartSteps client = new CartSteps();

    @Test
    void shouldReturnAllCarts() {
        List<CartDto> carts = client.getAllCarts(SC_OK);
        CartAssertions.assertCartFieldsNotEmpty(carts);
    }
}

package com.fakestoreapi.carts.steps;

import com.fakestoreapi.api.CartApi;
import com.fakestoreapi.carts.dto.CartDto;

import java.util.List;

public class CartSteps {

    CartApi cartApi = new CartApi();

    public List<CartDto> getAllCarts(int statusCode) {
        return cartApi.getAllCarts(statusCode).jsonPath().getList("", CartDto.class);
    }
}

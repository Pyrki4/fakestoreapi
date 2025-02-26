package com.fakestoreapi.carts.steps;

import com.fakestoreapi.api.CartApi;
import com.fakestoreapi.carts.dto.CartDto;

import java.util.List;

public class CartSteps {

    CartApi cartApi = new CartApi();

    public List<CartDto> getAllCarts(int statusCode) {
        return cartApi.getAll(statusCode).jsonPath().getList("", CartDto.class);
    }

    public CartDto getCartById(int statusCode, int cartId) {
        return cartApi.getById(statusCode, cartId).then().extract().as(CartDto.class);
    }

    public List<CartDto> getCartsWithLimit(int statusCode, int limit) {
        return cartApi.getWithLimit(statusCode, limit).jsonPath().getList("", CartDto.class);
    }
}

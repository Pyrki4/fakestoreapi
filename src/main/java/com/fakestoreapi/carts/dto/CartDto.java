package com.fakestoreapi.carts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private int id;
    private int userId;
    private String date;
    private Products[] products;

    @JsonIgnore
    private String __v;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Products {
        private int productId;
        private int quantity;
    }
}



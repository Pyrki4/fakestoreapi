package com.fakestoreapi.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Rating {
        private double rate;
        private int count;
    }
}

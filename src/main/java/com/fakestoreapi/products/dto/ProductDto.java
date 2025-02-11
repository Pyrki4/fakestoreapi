package com.fakestoreapi.products.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
    private Rating rating;

    @Data
    public static class Rating {
        private double rate;
        private int count;
    }
}

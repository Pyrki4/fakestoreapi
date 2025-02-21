package com.fakestoreapi.products.dto;

import lombok.Data;

@Data
public class NewProductDto {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

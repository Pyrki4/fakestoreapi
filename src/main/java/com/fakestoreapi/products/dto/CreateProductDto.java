package com.fakestoreapi.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateProductDto {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

package com.fakestoreapi.products.dto;

import lombok.Data;

@Data
public class NewProduct {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

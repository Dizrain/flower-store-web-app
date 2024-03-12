package com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRequestModel {

    String name;
    String description;
    String categoryId; // Assuming category is referenced by ID
    String category;
    BigDecimal price; // Assuming price as a simple numeric value for this example
}
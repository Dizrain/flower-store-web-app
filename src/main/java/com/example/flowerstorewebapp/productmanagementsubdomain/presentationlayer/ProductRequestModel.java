package com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer;

import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.Category;
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
    Long categoryId;
    Category category;
    BigDecimal price; // Assuming price as a simple numeric value for this example
}
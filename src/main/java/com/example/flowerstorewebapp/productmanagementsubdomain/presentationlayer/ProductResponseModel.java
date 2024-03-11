package com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel {

    String productId;
    String name;
    String description;
    String categoryName; // Assuming we want to send back the category name
    double price;
    String imageUrl; // URL to an image of the product
}

package com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel extends RepresentationModel<ProductResponseModel> {

    String productId;
    String name;
    String description;
    Long categoryId;
    String categoryName;
    double price;
}

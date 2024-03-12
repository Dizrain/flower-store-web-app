package com.example.flowerstorewebapp.orderprocessingsubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseModel extends RepresentationModel<OrderResponseModel> {

    String orderId;
    String customerId;
    List<OrderItemModel> items; // Similar to the request model, using an inner class for items
    String shippingAddress;
    String billingInformation;
    String status; // Example status values: "Placed", "Shipped", "Delivered", "Cancelled"

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItemModel extends RepresentationModel<OrderResponseModel> {
        String productId;
        String name; // Assuming we also want to include the product name, not just ID
        int quantity;
        double pricePerItem;
    }
}

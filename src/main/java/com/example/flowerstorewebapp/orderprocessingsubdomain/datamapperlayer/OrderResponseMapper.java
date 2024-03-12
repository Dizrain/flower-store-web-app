package com.example.flowerstorewebapp.orderprocessingsubdomain.datamapperlayer;

import com.example.flowerstorewebapp.orderprocessingsubdomain.datalayer.Order;
import com.example.flowerstorewebapp.orderprocessingsubdomain.presentationlayer.OrderController;
import com.example.flowerstorewebapp.orderprocessingsubdomain.presentationlayer.OrderResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {

    @Mapping(expression = "java(order.getIdentifier().getOrderId())", target = "orderId")
    OrderResponseModel entityToResponseModel(Order order);

    List<OrderResponseModel> entityListToResponseModelList(List<Order> orders);

    @AfterMapping
    default void addLinks(@MappingTarget OrderResponseModel model, Order order) {
        Link selfLink = linkTo(methodOn(OrderController.class).getOrderById(model.getOrderId())).withSelfRel();
        model.add(selfLink);

        // Example to add more links, adjust according to your API design
        // Link cancelLink = linkTo(methodOn(OrderController.class).cancelOrder(model.getOrderId())).withRel("cancelOrder");
        // model.add(cancelLink);
    }
}
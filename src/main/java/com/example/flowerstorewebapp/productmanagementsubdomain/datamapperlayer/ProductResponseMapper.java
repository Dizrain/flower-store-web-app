package com.example.flowerstorewebapp.productmanagementsubdomain.datamapperlayer;

import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.Product;
import com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer.ProductController;
import com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer.ProductResponseModel;
import lombok.Builder;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    @Mapping(expression = "java(product.getProductIdentifier().getProductId())", target = "productId")
ProductResponseModel entityToResponseModel(Product product);

    List<ProductResponseModel> entityListToResponseModelList(List<Product> products);

    @AfterMapping
    default void addLinks(@MappingTarget ProductResponseModel model, Product product){
        Link selfLink= linkTo(methodOn(ProductController.class)
                .getProductById(model.getProductId()))
                .withSelfRel();
        model.add(selfLink);
    }

}

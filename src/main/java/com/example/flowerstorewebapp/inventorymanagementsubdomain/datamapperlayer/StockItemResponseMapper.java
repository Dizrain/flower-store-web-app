package com.example.flowerstorewebapp.inventorymanagementsubdomain.datamapperlayer;

import com.example.flowerstorewebapp.inventorymanagementsubdomain.datalayer.StockItem;
import com.example.flowerstorewebapp.inventorymanagementsubdomain.presentationlayer.StockItemController;
import com.example.flowerstorewebapp.inventorymanagementsubdomain.presentationlayer.StockItemResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface StockItemResponseMapper {

    @Mapping(source = "stockItemIdentifier.stockItemId", target = "stockItemId")
    StockItemResponseModel entityToResponseModel(StockItem stockItem);

    List<StockItemResponseModel> entityListToResponseModelList(List<StockItem> stockItems);

    @AfterMapping
    default void addLinks(@MappingTarget StockItemResponseModel model, StockItem stockItem) {
        Link selfLink = linkTo(methodOn(StockItemController.class)
                .getStockItemByProductId(model.getProductId()))
                .withSelfRel();
        model.add(selfLink);
    }
}

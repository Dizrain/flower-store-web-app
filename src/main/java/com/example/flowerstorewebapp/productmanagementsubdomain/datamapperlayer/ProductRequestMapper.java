package com.example.flowerstorewebapp.productmanagementsubdomain.datamapperlayer;

import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.Product;
import com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer.ProductRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categoryName", target = "category")
    @Mapping(source = "priceValue", target = "price")
    Product requestModelToEntity(ProductRequestModel productRequestModel);
}

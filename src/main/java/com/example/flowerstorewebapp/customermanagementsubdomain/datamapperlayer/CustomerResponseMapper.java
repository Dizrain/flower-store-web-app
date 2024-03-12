package com.example.flowerstorewebapp.customermanagementsubdomain.datamapperlayer;

import com.example.flowerstorewebapp.customermanagementsubdomain.datalayer.Customer;
import com.example.flowerstorewebapp.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import com.example.flowerstorewebapp.orderprocessingsubdomain.presentationlayer.OrderResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

// TODO: Verify if this response mapper is complete since the product mapper seems to have more information.
@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {

    @Mapping(expression = "java(customer.getCustomerIdentifier().getCustomerId())", target = "customerId")
    CustomerResponseModel entityToResponseModel(Customer customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);
}
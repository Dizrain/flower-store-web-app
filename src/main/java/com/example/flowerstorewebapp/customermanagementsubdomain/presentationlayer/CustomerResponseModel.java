package com.example.flowerstorewebapp.customermanagementsubdomain.presentationlayer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseModel {

    String customerId;
    String name;
    String email;
    String contactNumber;
    String address;
}

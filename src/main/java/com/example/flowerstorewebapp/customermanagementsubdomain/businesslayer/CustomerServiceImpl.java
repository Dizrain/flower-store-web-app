package com.example.flowerstorewebapp.customermanagementsubdomain.businesslayer;

import com.example.flowerstorewebapp.customermanagementsubdomain.datalayer.Customer;
import com.example.flowerstorewebapp.customermanagementsubdomain.datalayer.CustomerRepository;
import com.example.flowerstorewebapp.customermanagementsubdomain.datamapperlayer.CustomerRequestMapper;
import com.example.flowerstorewebapp.customermanagementsubdomain.datamapperlayer.CustomerResponseMapper;
import com.example.flowerstorewebapp.customermanagementsubdomain.presentationlayer.CustomerRequestModel;
import com.example.flowerstorewebapp.customermanagementsubdomain.presentationlayer.CustomerResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerResponseMapper customerResponseMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerRequestMapper customerRequestMapper,
                               CustomerResponseMapper customerResponseMapper) {
        this.customerRepository = customerRepository;
        this.customerRequestMapper = customerRequestMapper;
        this.customerResponseMapper = customerResponseMapper;
    }

    @Override
    public List<CustomerResponseModel> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerById(String customerId) {
        Long id = Long.parseLong(customerId);
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        return customerResponseMapper.entityToResponseModel(customer);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel);
        Customer savedCustomer = customerRepository.save(customer);
        return customerResponseMapper.entityToResponseModel(savedCustomer);
    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomerModel, String customerId) {
        Long id = Long.parseLong(customerId);
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

        // Map the request model to the entity while preserving its ID
        Customer updatedCustomer = customerRequestMapper.requestModelToEntity(updatedCustomerModel);
        updatedCustomer.setId(id); // Ensure the correct ID is set

        Customer savedCustomer = customerRepository.save(updatedCustomer);
        return customerResponseMapper.entityToResponseModel(savedCustomer);
    }

    @Override
    public void removeCustomer(String customerId) {
        Long id = Long.parseLong(customerId);
        customerRepository.deleteById(id);
    }
}
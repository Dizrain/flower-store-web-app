package com.example.flowerstorewebapp.customermanagementsubdomain.datalayer;

import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Product, Long> {
}


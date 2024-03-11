package com.example.flowerstorewebapp.productmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByProductIdentifier_ProductId(String productId);
    List<Product> findAllByCategory_Name(String category);
}

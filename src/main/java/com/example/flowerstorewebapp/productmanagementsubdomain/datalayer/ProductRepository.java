package com.example.flowerstorewebapp.productmanagementsubdomain.datalayer;

import com.example.flowerstorewebapp.customermanagementsubdomain.datalayer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByProductIdentifier_ProductId(String productId);
    List<Product> findByCategoryId(Long categoryId);

    List<Product> findAllByCategoryId(Long categoryId);

    void deleteByProductIdentifier_ProductId(String productId);
}

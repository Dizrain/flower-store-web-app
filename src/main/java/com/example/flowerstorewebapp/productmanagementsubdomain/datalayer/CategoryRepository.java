package com.example.flowerstorewebapp.productmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional queries can be added here as needed
}
package com.example.flowerstorewebapp.productmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products") // Explicitly name the table
@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Private identifier

    @Embedded
    private ProductIdentifier productIdentifier;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    private String description;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    // If your application involves more complex category management, consider replacing the String category with a Category entity
    // @ManyToOne
    // @JoinColumn(name = "category_id", referencedColumnName = "id")
    // private Category category;
    // TODO: Category could be a separate entity (enum) that will support a limited amount of categories
}
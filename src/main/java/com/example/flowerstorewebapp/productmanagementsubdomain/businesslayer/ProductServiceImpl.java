package com.example.flowerstorewebapp.productmanagementsubdomain.businesslayer;

import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.Product;
import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.ProductIdentifier;
import com.example.flowerstorewebapp.productmanagementsubdomain.datalayer.ProductRepository;
import com.example.flowerstorewebapp.productmanagementsubdomain.datamapperlayer.ProductRequestMapper;
import com.example.flowerstorewebapp.productmanagementsubdomain.datamapperlayer.ProductResponseMapper;
import com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer.ProductRequestModel;
import com.example.flowerstorewebapp.productmanagementsubdomain.presentationlayer.ProductResponseModel;
import com.example.flowerstorewebapp.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductRequestMapper productRequestMapper,
                              ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public List<ProductResponseModel> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productResponseMapper.entityListToResponseModelList(products);
    }

    @Override
    public ProductResponseModel getProductById(String productId) {
        Long id = Long.parseLong(productId);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        return productResponseMapper.entityToResponseModel(product);
    }

    @Override
    public ProductResponseModel addProduct(ProductRequestModel productRequestModel) {
        Product product = productRequestMapper.requestModelToEntity(productRequestModel, new ProductIdentifier());
        Product savedProduct = productRepository.save(product);
        return productResponseMapper.entityToResponseModel(savedProduct);
    }

    @Override
    public ProductResponseModel updateProduct(ProductRequestModel updatedProductModel, String productId) {
        Product foundProduct = productRepository.findProductByProductIdentifier_ProductId(productId).orElseThrow(() -> new NotFoundException("Product not found with id " + productId));

        Product updatedProduct = productRequestMapper.requestModelToEntity(updatedProductModel, foundProduct.getProductIdentifier());
        updatedProduct.setId(foundProduct.getId()); // Ensure correct ID is set

        Product savedProduct = productRepository.save(updatedProduct);
        return productResponseMapper.entityToResponseModel(savedProduct);

    }

    @Override
    public void removeProduct(String productId) {
        Long id = Long.parseLong(productId);
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseModel> getProductsByCategory(String category) {
        List<Product> products = productRepository.findAllByCategory_Name(category);
        return productResponseMapper.entityListToResponseModelList(products);
    }
}

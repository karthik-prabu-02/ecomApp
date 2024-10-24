package com.ecom.productservice.service;

import com.ecom.productservice.entity.Category;
import com.ecom.productservice.entity.Product;
import com.ecom.productservice.model.ProductPurchaseResponse;
import com.ecom.productservice.model.ProductRequest;
import com.ecom.productservice.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product createProduct(ProductRequest productRequest) {
        return Product.builder()
                .productName(productRequest.productName())
                .description(productRequest.description())
                .availableQuantity(productRequest.availableQuantity())
                .price(productRequest.prices())
                .category(Category.builder().categoryId(productRequest.categoryId()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
          product.getProductId(),
          product.getProductName(),
          product.getDescription(),
          product.getAvailableQuantity(),
          product.getPrice(),
          product.getCategory().getCategoryId(),
          product.getCategory().getCategoryName(),
          product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getProductId(),
                product.getProductName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}

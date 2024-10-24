package com.ecom.productservice.service;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.exception.ProductPurchaseException;
import com.ecom.productservice.model.ProductPurchaseRequest;
import com.ecom.productservice.model.ProductPurchaseResponse;
import com.ecom.productservice.model.ProductRequest;
import com.ecom.productservice.model.ProductResponse;
import com.ecom.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer saveProduct(ProductRequest productRequest) {
        return productRepository.save(productMapper.createProduct(productRequest)).getProductId();
    }
    public List<ProductPurchaseResponse> purchaceProducts(@Valid List<ProductPurchaseRequest> request) {
        //extract list of productId from req object
        List<Integer> productId = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        //check productsIds from req object exists in db or not
        List<Product> storedProducts = productRepository.findAllByProductIdInOrderByProductId(productId);
        if(productId.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One Or More Products Does not Exists");
        }
        // sorting req object
        List<ProductPurchaseRequest> storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        // created objects of purchaseprocuct
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        // to check quantity of products we want to purchase is already avaliable
        for(int i =0; i<storedProducts.size();i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if(product.getAvailableQuantity() < productRequest.productQuantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with Id:: "+productRequest.productId());
            }
            // if quantity is available we need to process order... for that we adjust available quantity invotory and update it in db
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.productQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            //return list of purchased object
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product,productRequest.productQuantity()));
        }
        return purchasedProducts;
    }

    public ProductResponse findById(@Valid Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(()-> new EntityNotFoundException("Product not found with Id:: "+productId));
    }

    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}

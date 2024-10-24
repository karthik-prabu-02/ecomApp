package com.ecom.productservice.controller;

import com.ecom.productservice.model.ProductPurchaseRequest;
import com.ecom.productservice.model.ProductPurchaseResponse;
import com.ecom.productservice.model.ProductRequest;
import com.ecom.productservice.model.ProductResponse;
import com.ecom.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductServiceController {
    private final ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<Integer> saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaceProducts(@RequestBody @Valid List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(productService.purchaceProducts(request));
    }
    @GetMapping("/getProducts/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable @Valid Integer productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
}

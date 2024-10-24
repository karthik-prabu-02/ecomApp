package com.ecom.orderservice.client;

import com.ecom.orderservice.exception.BusinessException;
import com.ecom.orderservice.model.PurchaseRequet;
import com.ecom.orderservice.model.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequet> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequet>> requestEntity = new HttpEntity<>(requestBody,headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<List<PurchaseResponse>>() {};
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        if(responseEntity.getStatusCode().isError()) {
            throw new BusinessException("Error Occured while processing product purchase :: "+responseEntity.getStatusCode());
        }
        return  responseEntity.getBody();
    }
}

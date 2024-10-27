package com.ecom.notificationservice.model;

import com.ctc.wstx.io.BaseInputSource;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String productName,
        String description,
        BigDecimal productPrice,
        double productQuantity
) {
}

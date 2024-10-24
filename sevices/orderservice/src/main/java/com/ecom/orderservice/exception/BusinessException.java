package com.ecom.orderservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {
    private final String msg;
}

package com.ecom.customer.model;

import java.util.Map;

public record ErrorRespose (
        Map<String,String> errors
){
}

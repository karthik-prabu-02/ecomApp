package com.ecom.notificationservice.model;

import lombok.Getter;

public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment-confirmation.html","Payment Successfully processed"),
    ORDER_CONFIRMATION ("order-confirmation.html","Order confirmation");

    @Getter
    private  final String template;
    @Getter
    private final String subject;


    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}

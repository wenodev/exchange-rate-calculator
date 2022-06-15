package com.example.exchange.dto;

public class PriceRequest {
    private Double remittance;
    private String currency;

    public PriceRequest() {
    }

    public PriceRequest(Double remittance, String currency) {
        this.remittance = remittance;
        this.currency = currency;
    }

    public Double getRemittance() {
        return remittance;
    }

    public String getCurrency() {
        return currency;
    }
}

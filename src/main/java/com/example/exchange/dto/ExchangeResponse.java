package com.example.exchange.dto;

public class ExchangeResponse {
    private Double rate;

    public ExchangeResponse() {
    }

    public ExchangeResponse(Double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }
}

package com.example.exchange.dto;

public class PriceResponse {
    private String price;

    public static PriceResponse of(String price) {
        return new PriceResponse(price);
    }

    public PriceResponse() {

    }

    public PriceResponse(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}

package com.example.exchange.dto;

import java.util.Map;

public class CurrencyResponse {
    private boolean success;
    private Map<String, Double> quotes;

    public boolean isSuccess() {
        return success;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }
}

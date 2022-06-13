package com.example.exchange.dto;

import com.example.exchange.domain.ExchangeRate;

import java.util.Map;

public class ExchangeRateResponse {
    private boolean success;
    private Map<String, Double> quotes;

    public boolean isSuccess() {
        return success;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public ExchangeRate toExchangeRate() {
        return new ExchangeRate(quotes);
    }
}

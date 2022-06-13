package com.example.exchange.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExchangeRate {
    private static final String USD = "USD";

    private Map<String, Double> values = new HashMap<>();

    public ExchangeRate() {
    }

    public ExchangeRate(Map<String, Double> values) {
        this.values = values;
    }

    public Map<String, Double> getValues() {
        return values;
    }

    public boolean containsKey(String key) {
        return values.containsKey(key);
    }

    public void add(ExchangeRate exchangeRate) {
        Arrays.stream(Currency.values())
                .filter(currency -> exchangeRate.containsKey(USD + currency.name()))
                .collect(Collectors.toList())
                .forEach(currency -> {
                    Double rate = exchangeRate.getValues().get(USD + currency.name());
                    values.put(currency.name(), rate);
                });
    }
}

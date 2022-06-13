package com.example.exchange.domain;

public interface ExchangeRateRepository {
    void save(ExchangeRate exchangeRate);

    Double findRateByCurrency(String currency);
}

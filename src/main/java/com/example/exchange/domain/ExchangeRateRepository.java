package com.example.exchange.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository {
    void save(ExchangeRate exchangeRate);

    Double findRateByCurrency(String currency);
}

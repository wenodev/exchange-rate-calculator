package com.example.exchange.infra;

import com.example.exchange.domain.ExchangeRate;
import com.example.exchange.domain.ExchangeRateRepository;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {
    private static final ExchangeRate exchangeRate = new ExchangeRate();

    @Override
    public void save(ExchangeRate exchangeRate) {
        this.exchangeRate.add(exchangeRate);
    }

    @Override
    public Double findRateByCurrency(String currency) {
        return exchangeRate.getValues().get(currency);
    }
}

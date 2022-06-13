package com.example.exchange.config;

import com.example.exchange.application.ExchangeApi;
import com.example.exchange.domain.ExchangeRateRepository;
import com.example.exchange.dto.ExchangeRateResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializationConfig implements CommandLineRunner {
    private final ExchangeApi exchangeApi;
    private final ExchangeRateRepository exchangeRateRepository;

    public InitializationConfig(ExchangeApi exchangeApi, ExchangeRateRepository exchangeRateRepository) {
        this.exchangeApi = exchangeApi;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void run(String... args) {
        ExchangeRateResponse response = exchangeApi.getAllCurrencyRate();
        exchangeRateRepository.save(response.toExchangeRate());
    }
}

package com.example.exchange.application;

import com.example.exchange.domain.ExchangeRateRepository;
import com.example.exchange.dto.ExchangeResponse;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeResponse findByCurrency(String name) {
        Double rate = exchangeRateRepository.findRateByCurrency(name);
        return new ExchangeResponse(rate);
    }
}

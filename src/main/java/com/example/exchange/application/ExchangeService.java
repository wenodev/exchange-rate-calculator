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
        System.out.println(">>>>>>>>>>>>>>>>> 11");
        Double rate = exchangeRateRepository.findRateByCurrency(name);
        System.out.println(">>>>>>>>>>>>>>>>> 22");
        return new ExchangeResponse(rate);
    }
}

package com.example.exchange.application;

import com.example.exchange.domain.ExchangeRateRepository;
import com.example.exchange.dto.ExchangeResponse;
import com.example.exchange.dto.PriceRequest;
import com.example.exchange.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class ExchangeService {
    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeResponse findByCurrency(String name) {
        double rate = exchangeRateRepository.findRateByCurrency(name);
        return new ExchangeResponse(rate);
    }

    public PriceResponse calculatePrice(PriceRequest request) {
        double rate = exchangeRateRepository.findRateByCurrency(request.getCurrency());
        String price = calculate(request, rate);

        return PriceResponse.of(price);
    }

    private String calculate(PriceRequest request, double rate) {
        double price = request.getRemittance() * rate;
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(price);
    }
}

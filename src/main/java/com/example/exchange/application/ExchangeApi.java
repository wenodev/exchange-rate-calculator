package com.example.exchange.application;

import com.example.exchange.dto.ExchangeRateResponse;

public interface ExchangeApi {
    ExchangeRateResponse getAllCurrencyRate();
}

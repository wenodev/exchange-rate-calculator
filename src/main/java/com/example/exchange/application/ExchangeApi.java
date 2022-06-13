package com.example.exchange.application;

import com.example.exchange.dto.CurrencyResponse;

public interface ExchangeApi {
    CurrencyResponse getAllCurrencyRate();
}

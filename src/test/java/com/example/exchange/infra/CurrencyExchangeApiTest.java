package com.example.exchange.infra;

import com.example.exchange.dto.ExchangeRateResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyExchangeApiTest {
    @Test
    void getAllCurrencyRate() {
        CurrencyExchangeApi currencyExchangeApi = new CurrencyExchangeApi();
        ExchangeRateResponse allCurrencyRate = currencyExchangeApi.getAllCurrencyRate();
        assertThat(allCurrencyRate.isSuccess()).isTrue();
    }
}

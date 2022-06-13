package com.example.exchange.infra;

import com.example.exchange.dto.CurrencyResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyExchangeApiTest {
    @Test
    void test() {
        CurrencyExchangeApi currencyExchangeApi = new CurrencyExchangeApi();
        CurrencyResponse allCurrencyRate = currencyExchangeApi.getAllCurrencyRate();
        assertThat(allCurrencyRate.isSuccess()).isTrue();
    }
}

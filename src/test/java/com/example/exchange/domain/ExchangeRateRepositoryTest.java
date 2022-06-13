package com.example.exchange.domain;

import com.example.exchange.infra.ExchangeRateRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateRepositoryTest {
    @Test
    void save() {
        ExchangeRate exchangeRate = new ExchangeRate(StubExchangeRate.values());

        ExchangeRateRepository exchangeRateRepository = new ExchangeRateRepositoryImpl();
        exchangeRateRepository.save(exchangeRate);

        assertThat(exchangeRateRepository.findRateByCurrency("KRW")).isEqualTo(1287.035002);
    }
}

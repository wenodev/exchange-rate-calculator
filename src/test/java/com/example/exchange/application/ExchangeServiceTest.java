package com.example.exchange.application;

import com.example.exchange.domain.ExchangeRateRepository;
import com.example.exchange.dto.ExchangeResponse;
import com.example.exchange.dto.PriceRequest;
import com.example.exchange.dto.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ExchangeServiceTest {
    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private ExchangeService exchangeService;

    @Test
    void findByCurrency() {
        String KRW = "KRW";
        Double KRW_RATE = 1287.035002D;
        given(exchangeRateRepository.findRateByCurrency(KRW)).willReturn(KRW_RATE);

        ExchangeResponse response = exchangeService.findByCurrency(KRW);

        assertThat(response.getRate()).isEqualTo(KRW_RATE);
    }

    @Test
    void calculatePrice() {
        String KRW = "KRW";
        Double KRW_RATE = 1287.035002D;
        PriceRequest priceRequest = new PriceRequest(100D, KRW);
        given(exchangeRateRepository.findRateByCurrency(KRW)).willReturn(KRW_RATE);

        PriceResponse response = exchangeService.calculatePrice(priceRequest);

        assertThat(response.getPrice()).isEqualTo("128,703.50");
    }
}

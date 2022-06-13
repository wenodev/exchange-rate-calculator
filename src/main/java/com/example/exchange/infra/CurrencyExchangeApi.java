package com.example.exchange.infra;

import com.example.exchange.application.ExchangeApi;
import com.example.exchange.dto.ExchangeRateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyExchangeApi implements ExchangeApi {
    private final static String URL = "https://api.apilayer.com/currency_data/live?apikey=1EtO9LN5MClJ6dnLQpPnJqoIyA6X5AKT";
    private final static RestTemplate restTemplate = new RestTemplate();

    @Override
    public ExchangeRateResponse getAllCurrencyRate() {
        ResponseEntity<ExchangeRateResponse> response
                = restTemplate.getForEntity(URL, ExchangeRateResponse.class);

        return response.getBody();
    }
}

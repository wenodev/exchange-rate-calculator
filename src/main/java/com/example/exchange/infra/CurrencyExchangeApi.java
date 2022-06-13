package com.example.exchange.infra;

import com.example.exchange.application.ExchangeApi;
import com.example.exchange.dto.CurrencyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyExchangeApi implements ExchangeApi {
    @Override
    public CurrencyResponse getAllCurrencyRate() {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = "https://api.apilayer.com/currency_data/live?apikey=1EtO9LN5MClJ6dnLQpPnJqoIyA6X5AKT";
        ResponseEntity<CurrencyResponse> response
                = restTemplate.getForEntity(url, CurrencyResponse.class);

        return response.getBody();
    }
}

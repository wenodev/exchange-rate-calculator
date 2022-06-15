package com.example.exchange.contorller.api;

import com.example.exchange.application.ExchangeService;
import com.example.exchange.dto.ExchangeResponse;
import com.example.exchange.dto.PriceRequest;
import com.example.exchange.dto.PriceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeApiController {
    private final ExchangeService exchangeService;

    public ExchangeApiController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/currency/{name}")
    public ResponseEntity<ExchangeResponse> getExchangeRate(@PathVariable String name) {
        ExchangeResponse response = exchangeService.findByCurrency(name);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/price")
    public ResponseEntity<PriceResponse> calculatePrice(@RequestBody PriceRequest request) {
        PriceResponse response = exchangeService.calculatePrice(request);
        return ResponseEntity.ok().body(response);
    }
}

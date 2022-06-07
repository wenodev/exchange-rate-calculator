package com.example.exchange.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeController {
    @GetMapping(value = {"/", "/index"})
    public String home() {
        return "index";
    }
}

package com.example.exchange.domain;

import java.util.HashMap;
import java.util.Map;

public class StubExchangeRate {
    private static Map<String, Double> values = new HashMap<>();

    public static Map<String, Double> values() {
        values.put("USDAED", 3.673097);
        values.put("USDAFN", 89.672799);
        values.put("USDKRW", 1287.035002);
        values.put("USDJPY", 134.909948);
        values.put("USDPHP", 53.210989);
        return values;
    }
}

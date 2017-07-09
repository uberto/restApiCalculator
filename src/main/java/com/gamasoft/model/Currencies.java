package com.gamasoft.model;

import com.gamasoft.webserver.CalculationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uberto on 09/07/17.
 */
public class Currencies {

    //todo get recent data from
    //http://api.fixer.io/latest?base=USD

    private static Map<String, Double> toDollars = new HashMap<>();
    static {
        toDollars.put("EUR", 1.14);
        toDollars.put("GBP", 1.28);
        toDollars.put("INR", 0.015);
        toDollars.put("CHF", 1.03);
        toDollars.put("USD", 1.0);
    }

    public static double fxRate(String currency){
        if (!toDollars.containsKey(currency))
            throw new CalculationException("Currency not accepted " + currency);

        return toDollars.get(currency);
    }
}

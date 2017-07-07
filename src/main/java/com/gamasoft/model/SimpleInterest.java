package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Abstraction of a simple interest calculator
 */
public class SimpleInterest implements Calculation {
    @Override
    public String getPath() {
        return "simpleinterest/principal/:principal/years/:years/rate/:rate/fx/:fx";
    }

    @Override
    public double calcResult(Map<String, Double> params) {
        return params.get(":fx") * params.get(":principal") * params.get(":years") * (params.get(":rate") / 100.0);
    }
}

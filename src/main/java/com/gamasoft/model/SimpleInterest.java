package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Api for a simple interest calculator
 */
public class SimpleInterest implements Calculation {
    @Override
    public String getPath() {
        return "simpleinterest/principal/:principal/years/:years/rate/:rate/currency/:currency";
    }

    @Override
    public double calcResult(Map<String, String> params) {
        double fx = Currencies.fxRate(params.get(":currency"));
        return fx * Double.valueOf(params.get(":principal")) * Integer.valueOf(params.get(":years")) * (Double.valueOf(params.get(":rate")) / 100.0);
    }
}

package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Api for a compound interest calculator
 */
public class CompoundInterest implements Calculation {
    @Override
    public String getPath() {
        return "compound/principal/:principal/years/:years/periods/:periods/rate/:rate/fx/:fx";
    }

    @Override
    public double calcResult(Map<String, Double> params) {
        Double fx = params.get(":fx");
        Double p = params.get(":principal");
        Double t = params.get(":years");
        Double r = (params.get(":rate") / 100);
        Double n = params.get(":periods");
        return fx * (p * Math.pow((1 + r/n), (n*t)) - p) ;

    }
}

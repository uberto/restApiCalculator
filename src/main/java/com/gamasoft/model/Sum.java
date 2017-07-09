package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Example of route for integer sum
 */
public class Sum implements Calculation {
    @Override
    public String getPath() {
        return "sum/:a/:b";
    }

    @Override
    public double calcResult(Map<String, String> params) {
        return Double.valueOf(params.get(":a")) + Double.valueOf(params.get(":b"));
    }

}

package com.gamasoft.model;

import com.gamasoft.webserver.CalculatorRoute;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Example of route for integer sum
 */
public class Sum implements CalculatorRoute {
    @Override
    public String getPath() {
        return "sum/:a/:b";
    }

    @Override
    public Route getRoute() {
        return (request, response) -> {
            double a = Double.valueOf(request.params(":a"));
            double b = Double.valueOf(request.params(":b"));
            double v = a + b;
            return "result " + v;
        };
    }
}

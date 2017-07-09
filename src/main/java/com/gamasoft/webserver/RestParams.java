package com.gamasoft.webserver;

import com.gamasoft.model.Currencies;
import com.gamasoft.model.SimpleInterest;
import com.gamasoft.model.Sum;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * class used for params related logic
 */

public class RestParams {

    public static Map<String, String> extract(Calculation calc, String reqPath) {

        String[] modelParts = calc.getPath().split("/");
        String[] reqParts = reqPath.split("/");

        if (modelParts.length != reqParts.length)
            throw new CalculationException("Paths don't match " + reqPath + "   expected: " + calc.getPath());


        Map<String, String> res = new HashMap<>();

        IntStream.range(0, modelParts.length).forEach(x -> {
            if (modelParts[x].startsWith(":"))
                res.put(modelParts[x], reqParts[x]);
        });

        return res;
    }

    public static String getResponse(Calculation calc, String reqPath) {

        Map<String, String> p = extract(calc, reqPath);
        double r = calc.calcResult(p);

        return String.format("<html><body><h2>The return is</h2><p>%.2f</p></body></html>", r);
    }
}

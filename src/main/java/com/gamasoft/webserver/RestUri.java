package com.gamasoft.webserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * class used for uri related logic
 */

public class RestUri {

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

        Map<String, String> p = extract(calc, reqPath.substring(1));
        double r = calc.calcResult(p);

        return String.format("<html><body><h2>The return is</h2><p>%.2f</p></body></html>", r);
    }

    public static String createHelloResponse(List<Calculation> calculations) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><h1>Hello to the financial calculator!</h1>");
        sb.append("<p>List of rest api:</p>");

        sb.append("<ul>");
        for (Calculation c: calculations) {
            sb.append("<li>");
            sb.append(c.getPath());
            sb.append("</li>");
        }
        sb.append("</ul>");

        sb.append("</body></html>");

        return sb.toString();
    }
}

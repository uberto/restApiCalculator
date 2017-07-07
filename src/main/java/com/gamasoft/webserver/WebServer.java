package com.gamasoft.webserver;

import java.util.List;
import static spark.Spark.*;

/**
 * Main facade to Spark webserver
 */
public class WebServer {
    public static void start(int port, List<CalculatorRoute> routes) {
        port(port);

        for (CalculatorRoute r: routes) {
            get(r.getPath(), r.getRoute());
        }

        awaitInitialization();
    }
}

package com.gamasoft.webserver;

import java.util.List;

import static spark.Spark.*;

/**
 * Main facade to Spark webserver
 */
public class WebServer {
    public static void start(int port, List<Calculation> routes) {
        port(port);

        get("/", (request, response) -> RestUri.createHelloResponse(routes));
        for (Calculation r: routes) {
            get(r.getPath(), (request, response) -> RestUri.getResponse(r, request.uri()));
        }
    }

}

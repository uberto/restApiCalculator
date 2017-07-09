package com.gamasoft.webserver;

import spark.Route;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

/**
 * Main facade to Spark webserver
 */
public class WebServer {
    public static void start(int port, List<Calculation> routes) {
        port(port);

        get("/", (r,p) -> "Hello to the financial calculator!");
        for (Calculation r: routes) {
            get(r.getPath(), createRoute(r));
        }

        awaitInitialization();
    }

    private static Route createRoute(Calculation calculation) {

        return (request, response) -> RestParams.getResponse(calculation, request.uri().substring(1));

    }

}

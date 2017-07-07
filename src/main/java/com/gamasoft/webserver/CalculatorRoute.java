package com.gamasoft.webserver;

import spark.Route;

/**
 * Interface needed to create routes for spark webserver
 */
public interface CalculatorRoute {
    String getPath();

    Route getRoute();
}

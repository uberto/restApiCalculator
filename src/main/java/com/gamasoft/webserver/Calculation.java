package com.gamasoft.webserver;

import spark.Route;

import java.util.Map;

/**
 * Interface needed to create routes for spark webserver
 */
public interface Calculation {
    String getPath();

    double calcResult(Map<String, String> params);
}

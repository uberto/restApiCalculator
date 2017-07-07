package com.gamasoft;

import com.gamasoft.model.Calculations;
import com.gamasoft.webserver.CalculatorRoute;
import com.gamasoft.webserver.WebServer;

import java.util.List;

/**
 * class for the main method
 */
public class Main {


    public static void main(String[] args){
        List<CalculatorRoute> routes = Calculations.getAllCalculations();
        WebServer.start(8080, routes);
    }
}

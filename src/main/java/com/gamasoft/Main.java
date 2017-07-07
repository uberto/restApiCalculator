package com.gamasoft;

import com.gamasoft.webserver.Calculations;
import com.gamasoft.webserver.Calculation;
import com.gamasoft.webserver.WebServer;

import java.util.List;

/**
 * class for the main method
 */
public class Main {


    public static void main(String[] args){
        List<Calculation> routes = Calculations.getAllCalculations();
        WebServer.start(8080, routes);
    }
}

package com.gamasoft;

import com.gamasoft.webserver.Calculations;
import com.gamasoft.webserver.Calculation;
import com.gamasoft.webserver.ServerConfig;
import com.gamasoft.webserver.WebServer;
import org.aeonbits.owner.ConfigFactory;

import java.util.List;

/**
 * class for the main method
 */
public class Main {


    public static void main(String[] args){

        ServerConfig config = ConfigFactory.create(ServerConfig.class);

        List<Calculation> routes = Calculations.getAllCalculations(config.users());
        WebServer.start(config.port(), routes);
    }
}

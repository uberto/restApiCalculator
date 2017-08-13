package com.gamasoft.webserver;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import java.util.List;

/**
 * Keeps the configuration values for the server
 */
@Sources({ "file:config.properties" })
public interface ServerConfig extends Config {

    @DefaultValue("8008")
    int port();

    List<String> users();

}

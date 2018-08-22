package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Api for a simple interest calculator
 */
__ByValue public class SimpleInterest implements Calculation {
    final public UserAccounts userAccounts;

    public SimpleInterest(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String getPath() {
        return "simpleinterest/:username/principal/:principal/years/:years/rate/:rate/currency/:currency";
    }

    @Override
    public double calcResult(Map<String, String> params) {
        double fx = Currencies.fxRate(params.get(":currency"));
        double ret = fx * Double.valueOf(params.get(":principal")) * Integer.valueOf(params.get(":years")) * (Double.valueOf(params.get(":rate")) / 100.0);

        String u = params.get(":username");
        userAccounts.addReturnToUser(u, ret);

        return ret;
    }
}

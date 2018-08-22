package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Api for a compound interest calculator
 */
__ByValue public class CompoundInterest implements Calculation {

    public final UserAccounts userAccounts;

    public CompoundInterest(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String getPath() {
        return "compound/:username/principal/:principal/years/:years/periods/:periods/rate/:rate/currency/:currency";
    }

    @Override
    public double calcResult(Map<String, String> params) {
        Double fx = Currencies.fxRate(params.get(":currency"));
        Double p = Double.valueOf(params.get(":principal"));
        Double t = Double.valueOf(params.get(":years"));
        Double r = Double.valueOf(params.get(":rate")) / 100;
        Integer n = Integer.valueOf(params.get(":periods"));
        double ret = fx * (p * Math.pow((1 + r / n), (n * t)) - p);

        String u = params.get(":username");
        userAccounts.addReturnToUser(u, ret);
        return ret;

    }
}

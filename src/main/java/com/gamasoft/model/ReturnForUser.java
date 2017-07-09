package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Map;

/**
 * Api to return the total return for user
 */
public class ReturnForUser implements Calculation {
    private UserAccounts userAccounts;

    public ReturnForUser(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String getPath() {
        return "totalReturn/:username";
    }

    @Override
    public double calcResult(Map<String, String> params) {
        return userAccounts.currentReturnTotal(params.get(":username"));
    }
}

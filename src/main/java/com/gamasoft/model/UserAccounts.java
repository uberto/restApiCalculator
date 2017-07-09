package com.gamasoft.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * class to simulate a storage system for user returns
 */
public class UserAccounts {

    private Map<String, Double> accounts = new ConcurrentHashMap<>();

    public double addReturnToUser(String userName, double amount){
        return accounts.compute(userName, (u,a) -> (a == null ? 0.0 : a) + amount);
    }

    public double currentReturnTotal(String userName){
        return accounts.getOrDefault(userName, 0.0);
    }
}

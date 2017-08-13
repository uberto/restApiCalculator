package com.gamasoft.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * class to simulate a storage system for user returns
 */
public class UserAccounts {

    private Map<String, Double> accounts = new ConcurrentHashMap<>();

    public UserAccounts(List<String> users) {
        for (String u: users) {
            accounts.put(u, 0.0);
        }
    }

    public void addReturnToUser(String userName, double amount){

        accounts.computeIfPresent(userName, (String u, Double a) -> amount + a);
    }


    public double currentReturnTotal(String userName){
        return accounts.getOrDefault(userName, 0.0);
    }
}

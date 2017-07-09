package com.gamasoft.webserver;

import com.gamasoft.model.CompoundInterest;
import com.gamasoft.model.ReturnForUser;
import com.gamasoft.model.SimpleInterest;
import com.gamasoft.model.UserAccounts;
import com.gamasoft.webserver.Calculation;

import java.util.Arrays;
import java.util.List;

/**
 * container of all active calculations
 */
public class Calculations {
    public static List<Calculation> getAllCalculations() {
        UserAccounts ua = new UserAccounts();
        return Arrays.asList(new SimpleInterest(ua), new CompoundInterest(ua), new ReturnForUser(ua));
    }
}

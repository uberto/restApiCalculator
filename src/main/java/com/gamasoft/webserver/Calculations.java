package com.gamasoft.webserver;

import com.gamasoft.model.SimpleInterest;
import com.gamasoft.webserver.Calculation;

import java.util.Arrays;
import java.util.List;

/**
 * container of all active calculations
 */
public class Calculations {
    public static List<Calculation> getAllCalculations() {
        return Arrays.asList(new SimpleInterest());
    }
}

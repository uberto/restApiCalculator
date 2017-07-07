package com.gamasoft.model;

import com.gamasoft.webserver.CalculatorRoute;

import java.util.Arrays;
import java.util.List;

/**
 * container of all active calculations
 */
public class Calculations {
    public static List<CalculatorRoute> getAllCalculations() {
        return Arrays.asList(new Sum());
    }
}

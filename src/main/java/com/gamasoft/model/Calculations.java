package com.gamasoft.model;

import com.gamasoft.webserver.Calculation;

import java.util.Arrays;
import java.util.List;

/**
 * container of all active calculations
 */
public class Calculations {
    public static List<Calculation> getAllCalculations() {
        return Arrays.asList(new Sum());
    }
}

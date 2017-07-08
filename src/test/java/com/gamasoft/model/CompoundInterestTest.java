package com.gamasoft.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class CompoundInterestTest {

    @Test
    public void calculateInterestOn1YearWithOnePeriod() throws Exception {

        CompoundInterest s = new CompoundInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 1.0);
        params.put(":principal", 10.0);
        params.put(":periods", 1.0);
        params.put(":rate", 10.0);
        params.put(":fx", 1.0);
        assertEquals(1.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearWith12Period() throws Exception {

        CompoundInterest s = new CompoundInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 10.0);
        params.put(":principal", 5000.0);
        params.put(":periods", 12.0);
        params.put(":rate", 5.0);
        params.put(":fx", 1.0);
        assertEquals(3235.047488, s.calcResult(params), 0.0001);

    }


    @Test
    public void calculateInterestOn15YearWith12PeriodWithFx() throws Exception {

        CompoundInterest s = new CompoundInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 15.0);
        params.put(":principal", 1000.0);
        params.put(":periods", 12.0);
        params.put(":rate", 4.0);
        params.put(":fx", 1.1);
        assertEquals(902.331, s.calcResult(params), 0.01);

    }
}
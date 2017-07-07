package com.gamasoft.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by uberto on 07/07/17.
 */
public class SimpleInterestTest {

    @Test
    public void calculateInterestOn1Year() throws Exception {

        SimpleInterest s = new SimpleInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 1.0);
        params.put(":principal", 10.0);
        params.put(":rate", 20.0);
        params.put(":fx", 1.0);
        assertEquals(2.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn5Years() throws Exception {

        SimpleInterest s = new SimpleInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 5.0);
        params.put(":principal", 10.0);
        params.put(":rate", 10.0);
        params.put(":fx", 1.0);
        assertEquals(5.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearsWithFx() throws Exception {

        SimpleInterest s = new SimpleInterest();

        Map<String, Double> params = new HashMap<>();
        params.put(":years", 10.0);
        params.put(":principal", 10.0);
        params.put(":rate", 5.0);
        params.put(":fx", 1.1);
        assertEquals(5.5, s.calcResult(params), 0.0001);

    }
}

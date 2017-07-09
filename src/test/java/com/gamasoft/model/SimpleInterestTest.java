package com.gamasoft.model;

import com.gamasoft.webserver.RestParams;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimpleInterestTest {

    @Test
    public void calculateInterestOn1Year() throws Exception {

        SimpleInterest s = new SimpleInterest();

        Map<String, String> params = RestParams.extract(s, "simpleinterest/principal/10/years/1/rate/20/currency/USD");
        assertEquals(2.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn5Years() throws Exception {

        SimpleInterest s = new SimpleInterest();

        Map<String, String> params = RestParams.extract(s, "simpleinterest/principal/10/years/5/rate/10/currency/USD");
        assertEquals(5.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearsWithFx() throws Exception {

        SimpleInterest s = new SimpleInterest();

        String reqPath = "simpleinterest/principal/10/years/10/rate/5/currency/EUR";
        Map<String, String> params = RestParams.extract(s, reqPath);

        assertEquals(5.7, s.calcResult(params), 0.0001);

    }
}

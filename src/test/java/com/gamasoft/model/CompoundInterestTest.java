package com.gamasoft.model;

import com.gamasoft.webserver.RestParams;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class CompoundInterestTest {

    @Test
    public void calculateInterestOn1YearWithOnePeriod() throws Exception {

        CompoundInterest s = new CompoundInterest();


        String reqPath = "compound/principal/10/years/1/periods/1/rate/10/fx/1";
        Map<String, Double> params = RestParams.extract(s, reqPath);

        assertEquals(1.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearWith12Period() throws Exception {

        CompoundInterest s = new CompoundInterest();

        String reqPath = "compound/principal/5000/years/10/periods/12/rate/5/fx/1";
        Map<String, Double> params = RestParams.extract(s, reqPath);

        assertEquals(3235.047488, s.calcResult(params), 0.0001);

    }


    @Test
    public void calculateInterestOn15YearWith12PeriodWithFx() throws Exception {

        CompoundInterest s = new CompoundInterest();

        String reqPath = "compound/principal/1000/years/15/periods/12/rate/4/fx/1.1";
        Map<String, Double> params = RestParams.extract(s, reqPath);

        assertEquals(902.331, s.calcResult(params), 0.01);

    }
}
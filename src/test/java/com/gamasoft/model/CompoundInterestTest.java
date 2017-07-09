package com.gamasoft.model;

import com.gamasoft.webserver.RestUri;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class CompoundInterestTest {

    @Test
    public void calculateInterestOn1YearWithOnePeriod() throws Exception {

        CompoundInterest s = new CompoundInterest(new UserAccounts());


        String reqPath = "compound/fred/principal/10/years/1/periods/1/rate/10/currency/USD";
        Map<String, String> params = RestUri.extract(s, reqPath);

        assertEquals(1.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearWith12Period() throws Exception {

        CompoundInterest s = new CompoundInterest(new UserAccounts());

        String reqPath = "compound/fred/principal/5000/years/10/periods/12/rate/5/currency/USD";
        Map<String, String> params = RestUri.extract(s, reqPath);

        assertEquals(3235.047488, s.calcResult(params), 0.0001);

    }


    @Test
    public void calculateInterestOn15YearWith12PeriodWithFx() throws Exception {

        CompoundInterest s = new CompoundInterest(new UserAccounts());

        String reqPath = "compound/fred/principal/1000/years/15/periods/12/rate/4/currency/GBP";
        Map<String, String> params = RestUri.extract(s, reqPath);

        assertEquals(1049.986, s.calcResult(params), 0.01);

    }


    @Test
    public void addReturnToUserAccount() throws Exception {

        UserAccounts accounts = new UserAccounts();
        accounts.addReturnToUser("fred", 9.0);
        CompoundInterest s = new CompoundInterest(accounts);

        String reqPath = "compound/fred/principal/10/years/1/periods/1/rate/10/currency/USD";
        Map<String, String> params = RestUri.extract(s, reqPath);
        assertEquals(1.0, s.calcResult(params), 0.0001);

        assertEquals(10.0, accounts.currentReturnTotal("fred"), 0.0001);

    }
}
package com.gamasoft.model;

import com.gamasoft.webserver.RestUri;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimpleInterestTest {

    @Test
    public void calculateInterestOn1Year() throws Exception {

        SimpleInterest s = new SimpleInterest(new UserAccounts());

        Map<String, String> params = RestUri.extract(s, "simpleinterest/joe/principal/10/years/1/rate/20/currency/USD");
        assertEquals(2.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void addReturnToUserAccount() throws Exception {

        UserAccounts accounts = new UserAccounts();
        accounts.addReturnToUser("joe", 8.0);
        SimpleInterest s = new SimpleInterest(accounts);

        Map<String, String> params = RestUri.extract(s, "simpleinterest/joe/principal/10/years/1/rate/20/currency/USD");

        assertEquals(2.0, s.calcResult(params), 0.0001);

        assertEquals(10.0, accounts.currentReturnTotal("joe"), 0.0001);

    }

    @Test
    public void calculateInterestOn5Years() throws Exception {

        SimpleInterest s = new SimpleInterest(new UserAccounts());

        Map<String, String> params = RestUri.extract(s, "simpleinterest/joe/principal/10/years/5/rate/10/currency/USD");
        assertEquals(5.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void calculateInterestOn10YearsWithFx() throws Exception {

        SimpleInterest s = new SimpleInterest(new UserAccounts());

        String reqPath = "simpleinterest/joe/principal/10/years/10/rate/5/currency/EUR";
        Map<String, String> params = RestUri.extract(s, reqPath);

        assertEquals(5.7, s.calcResult(params), 0.0001);

    }
}

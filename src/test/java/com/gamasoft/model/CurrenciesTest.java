package com.gamasoft.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrenciesTest {

    @Test
    public void oneDollarIsWorthOneDollar() throws Exception {

        assertEquals(1.0, Currencies.fxRate("USD"), 0.0001);
    }

    @Test
    public void oneGBPIsWorthMoreSomething() throws Exception {

        assertTrue(Currencies.fxRate("GBP") > 0.0);
    }
}
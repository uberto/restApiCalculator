package com.gamasoft.webserver;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculationsTest {

    @Test
    public void allCalculationsMustHaveAPath() throws Exception {

        List<Calculation> l  = Calculations.getAllCalculations();

        for (Calculation c: l) {
            assertFalse(c.getPath().isEmpty());
        }


    }
}
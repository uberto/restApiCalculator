package com.gamasoft.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class SumTest {

    @Test
    public void SumOf3And4ShouldReturn7() throws Exception {

        Sum s = new Sum();

        Map<String, Double> params = new HashMap<>();
        params.put(":a", 3.0);
        params.put(":b", 4.0);
        assertEquals(7, s.calcResult(params), 0.0001);

    }
}
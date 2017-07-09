package com.gamasoft.webserver;

import com.gamasoft.model.SimpleInterest;
import com.gamasoft.model.Sum;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RestParamsTest {


    @Test
    public void extractParamsComparingActualPathWithExpectedPathModel() throws Exception {

            Sum s = new Sum();


            Map<String, Double> params = RestParams.extract(s, "sum/42/10.25");


            assertEquals(42.0, params.get(":a"), 0.0001);
            assertEquals(10.25, params.get(":b"), 0.0001);

    }


    @Test
    public void calculateResultAndWrapInHtml() throws Exception {

        Sum s = new Sum();


        String response = RestParams.getResponse(s, "sum/42/10.25");


        assertEquals("<html><body><h2>The return is</h2><p>52.25</p></body></html>", response);

    }

    @Test (expected = CalculationException.class)
    public void raiseExceptionWhenPathDontMatch() throws Exception {

        Sum s = new Sum();


        Map<String, Double> params = RestParams.extract(s, "sum/a/42/b/10.25");


        assertEquals(42.0, params.get(":a"), 0.0001);
        assertEquals(10.25, params.get(":b"), 0.0001);

    }
}
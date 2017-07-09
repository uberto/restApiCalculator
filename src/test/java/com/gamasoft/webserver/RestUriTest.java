package com.gamasoft.webserver;

import com.gamasoft.model.Sum;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RestUriTest {


    @Test
    public void extractParamsComparingActualPathWithExpectedPathModel() throws Exception {

            Sum s = new Sum();


            Map<String, String> params = RestUri.extract(s, "sum/42/10.25");


            assertEquals("42", params.get(":a"));
            assertEquals("10.25", params.get(":b"));

    }


    @Test
    public void calculateResultAndWrapInHtml() throws Exception {

        Sum s = new Sum();
        String response = RestUri.getResponse(s, "sum/42/10.25");

        assertEquals("<html><body><h2>The return is</h2><p>52.25</p></body></html>", response);

    }

    @Test (expected = CalculationException.class)
    public void raiseExceptionWhenPathDontMatch() throws Exception {

        Sum s = new Sum();


        Map<String, String> params = RestUri.extract(s, "sum/a/42/b/10.25");

    }

    @Test
    public void createHelloPageWithAllCalculationsPath() throws Exception {

        String hello = RestUri.createHelloResponse(Calculations.getAllCalculations());

        assertEquals(337, hello.length());

    }

}
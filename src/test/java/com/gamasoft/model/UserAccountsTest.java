package com.gamasoft.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserAccountsTest {
    UserAccounts ua = new UserAccounts(List.of("joe", "frank", "annie"));

    @Test
    public void currentTotalShouldRetunTheSumOfAllReturn() throws Exception {

        ua.addReturnToUser("joe", 100);
        assertEquals(100.0, ua.currentReturnTotal("joe"), 0.0001);

        ua.addReturnToUser("joe", 50);
        assertEquals(150.0, ua.currentReturnTotal("joe"), 0.0001);

        ua.addReturnToUser("joe", 27.5);
        assertEquals(177.5, ua.currentReturnTotal("joe"), 0.0001);
    }

    @Test
    public void firstAmountShouldBeZero() throws Exception {

        assertEquals(0.0, ua.currentReturnTotal("joe"), 0.0001);


    }

    @Test
    public void addAmountToAccountShouldNotAffectOtherUsers() throws Exception {

        ua.addReturnToUser("joe", 100);
        ua.addReturnToUser("frank", 110);
        ua.addReturnToUser("annie", 120);

        assertEquals(100.0, ua.currentReturnTotal("joe"), 0.0001);


    }
}
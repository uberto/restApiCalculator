package com.gamasoft.model;

import com.gamasoft.webserver.RestUri;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ReturnForUserTest {

    @Test
    public void showTheCurrentAccountForUser() throws Exception {
        UserAccounts userAccounts = new UserAccounts(List.of("annie"));
        userAccounts.addReturnToUser("annie", 12);
        ReturnForUser s = new ReturnForUser(userAccounts);

        Map<String, String> params = RestUri.extract(s, "totalReturn/annie");
        assertEquals(12.0, s.calcResult(params), 0.0001);

    }

    @Test
    public void showTheCurrentAccountForNonExistantUser() throws Exception {
        UserAccounts userAccounts = new UserAccounts(List.of("annie"));
        userAccounts.addReturnToUser("mary", 12);
        ReturnForUser s = new ReturnForUser(userAccounts);

        Map<String, String> params = RestUri.extract(s, "totalReturn/mary");
        assertEquals(0.0, s.calcResult(params), 0.0001);

    }
}
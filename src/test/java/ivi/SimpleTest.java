package ivi;

import ivi.actions.Config;
import ivi.method.APIAuthorization;
import org.junit.Assert;

import java.io.IOException;

public class SimpleTest {
    public static void main (String[] args) throws IOException {
        Config config = new Config();
        String login = config.getClientId();
        String password = config.getClientSecret();
        String address = config.getAddressAPI() + "/ru";
        APIAuthorization action = new APIAuthorization(address, login, password);
        action.run();
        Assert.assertEquals(action.getResponseCode(), 200);
        String token = action.getToken();
        System.out.println("test SUCCESS");
    }
}

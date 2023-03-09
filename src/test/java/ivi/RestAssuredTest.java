package ivi;

import io.qameta.allure.Step;
import ivi.actions.Config;
import ivi.method.restassured.auth.JsonBodyAuth;
import ivi.method.restassured.auth.ResponseAuth;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class RestAssuredTest {

    @Test
    public void testAuthRestAssured() throws IOException, URISyntaxException {
        Config config = new Config();
        String address = config.getAddressAPI();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();
        String dealerId = config.getDealerApi();
        String dealerAddress = config.getDealerAddressApi();
        String creditorExternalId = config.getCreditorExternalId();
        String imei = config.getImei();
        String token = getTokenInAuth(clientId, clientSecret, address);
    }
    @Step("запрос токена")
    private String getTokenInAuth(String clientId, String clientSecret, String address){
        JsonBodyAuth jsonBodyAuth = new JsonBodyAuth(clientId, clientSecret);
        String requestBody = jsonBodyAuth.getBody();
        return new ResponseAuth(address, requestBody).getTokenFromResponse();
    }
}

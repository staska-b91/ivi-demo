package ivi;

import io.qameta.allure.Step;
import ivi.actions.Config;
import ivi.method.restassured.auth.JsonBodyAuth;
import ivi.method.restassured.auth.ResponseAuth;
import ivi.method.restassured.lightreg.BodyByReg;
import ivi.method.restassured.lightreg.LightRegistration;
import org.junit.Test;

public class RestAssuredTest {

    @Test
    public void testAuthRestAssured() {
        Config config = new Config();
        String address = config.getAddressAPI();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();
        String token = getTokenInAuth(clientId, clientSecret, address);
        registration(address, token);
    }
    @Step("запрос токена")
    private String getTokenInAuth(String clientId, String clientSecret, String address){
        JsonBodyAuth jsonBodyAuth = new JsonBodyAuth(clientId, clientSecret);
        String requestBody = jsonBodyAuth.getBody();
        return new ResponseAuth(address, requestBody).getTokenFromResponse();
    }
    @Step("предварительная регистрация")
    private void registration(String address, String token){
        Config config = new Config();
        String dealerId = config.getDealerApi();
        String dealerAddress = config.getDealerAddressApi();
        String creditorExternalId = config.getCreditorExternalId();
        String imei = config.getImei();
        String requestBody = new BodyByReg(imei, dealerId, dealerAddress, creditorExternalId).getBody("/linkreg.json");
        new LightRegistration(address, token, requestBody).checkThatResponseSucces();
    }
}

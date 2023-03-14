package ivi;

import io.qameta.allure.Step;
import ivi.actions.Config;
import ivi.method.restassured.auth.JsonBodyAuth;
import ivi.method.restassured.auth.ResponseAuth;
import ivi.method.restassured.lightreg.BodyByReg;
import ivi.method.restassured.lightreg.LightRegistration;
import org.junit.Assert;
import org.junit.Test;

public class RestAssuredTest {

    @Test
    public void testAuthRestAssuredSuccess() {
        Config config = new Config();
        String address = config.getAddressAPI();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();
        String imei = config.getImei();
        String token = getTokenInAuth(clientId, clientSecret, address);
        registrationSuccess(address, token);
        //повторная рега
        String errors = registrationWithError(address, token);
        Assert.assertEquals("IMEI " + imei +" в процессе регистрации в Запросто!", errors);
    }
    @Step("запрос токена")
    private String getTokenInAuth(String clientId, String clientSecret, String address){
        JsonBodyAuth jsonBodyAuth = new JsonBodyAuth(clientId, clientSecret);
        String requestBody = jsonBodyAuth.getBody();
        return new ResponseAuth(address, requestBody).getTokenFromResponse();
    }
    @Step("предварительная регистрация успешная")
    private void registrationSuccess(String address, String token){
        String requestBody = makeBodyForRequest();
        new LightRegistration(address, token, requestBody).checkThatResponseSuccess();
    }
    @Step("создание тела заппоса")
    private String makeBodyForRequest(){
        Config config = new Config();
        String dealerId = config.getDealerApi();
        String dealerAddress = config.getDealerAddressApi();
        String creditorExternalId = config.getCreditorExternalId();
        String imei = config.getImei();
        String requestBody = new BodyByReg(imei, dealerId, dealerAddress, creditorExternalId).getBody("/linkreg.json");
        return requestBody;
    }
    @Step("предварительная регистрация повторная - ошибка")
    private String registrationWithError(String address, String token){
        String requestBody = makeBodyForRequest();
        String errors = new LightRegistration(address, token, requestBody).checkThatResponseWithError();
        return errors;
    }
}

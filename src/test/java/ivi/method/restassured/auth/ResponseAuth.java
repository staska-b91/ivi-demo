package ivi.method.restassured.auth;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import ivi.method.restassured.method.ResponseBase;
import ivi.method.restassured.method.RestUtils;
import ivi.response.UserTokenApiRequest;
import org.junit.Assert;
import java.lang.reflect.Type;
import java.util.Map;

public class ResponseAuth extends AbstractAuth {
    private String address;
    private String requestBody;
    private Map<String, String> headers;

    public ResponseAuth(String address, String requestBody){
        this.address = address;
        this.requestBody = requestBody;
        this.headers = getHeaders();
    }

    public String getTokenFromResponse(){
        Map<String, String> headers = getHeaders();
        Response response = makeResp(address + getUrl(), requestBody, headers);
        UserTokenApiRequest bodyModel = checkThatResponseSuccess(response);
        return readTokenFromResponse(bodyModel);
    }
    private Response makeResp(String address, String requestBody, Map<String, String> headers) {
        return RestUtils.performPost(address, requestBody, headers);
    }
    private String readTokenFromResponse(UserTokenApiRequest bodyModel) {
        String token = bodyModel.getAccessToken();
        assertionToken(token);
        return token;
    }
    private UserTokenApiRequest checkThatResponseSuccess(Response response){
        new ResponseBase(response).assertionStatusResponseSuccess();
        ResponseBody responseBody = response.body();
        UserTokenApiRequest bodyModel = responseBody.as((Type) UserTokenApiRequest.class);
        Assert.assertNotNull(bodyModel.getAccessToken());
        Assert.assertNotNull(bodyModel.getExpiresIn());
        Assert.assertNotNull(bodyModel.getTokenType());
        return bodyModel;
    }
    private void assertionToken(String token) {
        Assert.assertNotNull(token);
        System.out.println("-------------");
        System.out.println("ТОКЕН ПОЛУЧЕН");
        System.out.println("-------------");
    }
}

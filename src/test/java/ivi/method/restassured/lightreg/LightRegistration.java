package ivi.method.restassured.lightreg;

import io.restassured.response.Response;
import ivi.method.restassured.method.ResponseBase;
import ivi.method.restassured.method.RestUtils;

import java.util.Map;

public class LightRegistration extends AbstractReg {
    private String address;
    private String token;
    private String body;

    public LightRegistration(String address, String token, String body){
        this.address = address;
        this.token = token;
        this.body = body;
    }
    private Map<String, String> sentTokenAsHeader(Map<String, String> headers, String token){
        headers.put("Authorization","Bearer " + token);
        return headers;
    }
    private Response makeResp(String address, String requestBody, Map<String, String> headers) {
        return RestUtils.performPost(address + getUrl(), requestBody, headers);
    }
    public void checkThatResponseSucces(){
        Map<String, String> headers = sentTokenAsHeader(getHeaders(), token);
        Response response = makeResp(address, body, headers);
        new ResponseBase(response).assertionStatusResponseSuccess();
//        ResponseBody responseBody = response.body();
//        String statusLoan = responseBody.path("status");
//        Assert.assertEquals("SuccessApplied", statusLoan);
//        JSONObject jsonObjectBody = new JSONObject(responseBody);
//        String statusDevice = JsonPath.from(jsonObjectBody.toString()).getString("products[0].status");
//        Assert.assertEquals("NotProcessed", statusDevice);
    }
}

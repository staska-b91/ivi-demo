package ivi.method.restassured.lightreg;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import ivi.method.restassured.BadRequestModel;
import ivi.method.restassured.method.RestUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LightRegistration extends RestUtils {
    private String address;
    private String token;
    private String body;

    public LightRegistration(String address, String token, String body){
        this.address = address;
        this.token = token;
        this.body = body;
    }
    private Response makeResp(String address, String requestBody, Map<String, String> headers) {
        return RestUtils.performPost(address + "/LightLoans", requestBody, headers);
    }
    public void checkThatResponseSuccess(){
        Map<String, String> headersReg = new HashMap<>();
        headersReg.put("Content-Type", "application/json");
        Map<String, String> headers = sentTokenAsHeader(headersReg, token);
        Response response = makeResp(address, body, headers);
        assertionStatusResponseSuccess(response);
    }
    public String getErrorText(){
        Map<String, String> headersReg = new HashMap<>();
        headersReg.put("Content-Type", "application/json");
        Map<String, String> headers = sentTokenAsHeader(headersReg, token);
        Response response = makeResp(address, body, headers);
        assertionStatusResponseWithErrors(response);
        ResponseBody responseBody = response.body();
        BadRequestModel body = responseBody.as((Type) BadRequestModel.class);
        List<String> errs = new ArrayList<>();
        body.getErrors()
                .values()
                .forEach(errs::addAll);

        String errors = String.join(" ", errs);
        return errors;
    }
}

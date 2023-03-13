package ivi.method.restassured.method;

import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;

public class ResponseBase {
    private Response response;
    private Map<String, String> headers;
    private String token;

    public void assertionStatusResponseSuccess(Response response) {
        Assert.assertEquals(response.statusCode(), 200);
    }
    public Map<String, String> sentTokenAsHeader(Map<String, String> headers, String token){
        headers.put("Authorization","Bearer " + token);
        return headers;
    }
}

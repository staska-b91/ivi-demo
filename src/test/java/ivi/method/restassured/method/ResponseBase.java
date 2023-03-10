package ivi.method.restassured.method;

import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseBase {
    private Response response;
    public ResponseBase(Response response){
        this.response = response;
    }
    public void assertionStatusResponseSuccess() {
        Assert.assertEquals(response.statusCode(), 200);
    }
}

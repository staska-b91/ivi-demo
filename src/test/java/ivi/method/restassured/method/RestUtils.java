package ivi.method.restassured.method;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ivi.SpecificationFactory;
import org.junit.Assert;
import java.util.Map;

public class RestUtils {

    private static RequestSpecification getReguestSpec(String requestBody, Map<String, String> headers) {
        return RestAssured.given()
                .spec(SpecificationFactory.reqSpec())
                .filter(new AllureRestAssured())
                .headers(headers)
                .body(requestBody);
    }

    public static Response performPost(String url, String requestBody, Map<String, String> headers) {
        RequestSpecification requestSpecification = getReguestSpec(requestBody, headers);
        return requestSpecification
                .post(url);
    }
    public void assertionStatusResponseSuccess(Response response) {
        Assert.assertEquals(response.statusCode(), 200);
    }
    public Map<String, String> sentTokenAsHeader(Map<String, String> headers, String token){
        headers.put("Authorization","Bearer " + token);
        return headers;
    }
    public void assertionStatusResponseWithErrors(Response response) {
        Assert.assertEquals(response.statusCode(), 400);
    }
}

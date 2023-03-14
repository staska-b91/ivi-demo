package ivi.method.restassured.method;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ivi.SpecificationFactory;
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
}

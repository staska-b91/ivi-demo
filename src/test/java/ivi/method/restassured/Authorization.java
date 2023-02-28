package ivi.method.restassured;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import ivi.SpecificationFactory;
import org.json.JSONObject;
import org.junit.Assert;

/**
 * метод реализует авторизацию в АПИ и получение токена
 */
public class Authorization {
    private String clientId;
    private String clientSecret;
    private String address;

    public Authorization(String address, String clientId, String clientSecret){
        this.address = address;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String run(){
        //создание json для rq
        JSONObject requestBody = new JSONObject();
        requestBody.put("clientId", clientId);
        requestBody.put("clientSecret", clientSecret);

        ResponseBody respBody = RestAssured.given()
                .spec(SpecificationFactory.reqSpec())
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(address + "/api/OAuth/access-token")
                .then()
                .spec(SpecificationFactory.respSpec())
                .statusCode(200)
                .extract()
                .response()
                .body();
        //получение токена из rs body
        String token = respBody
                .path("accessToken");

        Assert.assertNotNull(token);
        System.out.println("-------------");
        System.out.println("ТОКЕН ПОЛУЧЕН");
        System.out.println("-------------");
        return token;
    }
}

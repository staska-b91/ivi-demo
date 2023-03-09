package ivi.method.restassured.lightreg;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import ivi.SpecificationFactory;

public class LightReg {
    private String address;
    private String token;
    private String body;

    public LightReg(String address, String token, String body){
        this.address = address;
        this.token = token;
        this.body = body;
    }
    public void run(){
        ResponseBody respBody = RestAssured.given()
                .spec(SpecificationFactory.reqSpec())
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + token)
                .body(body)
                .post(address + "/LightLoans")
                .then()
                .spec(SpecificationFactory.respSpec())
                .statusCode(200)
                .extract()
                .response()
                .body();
    }
}

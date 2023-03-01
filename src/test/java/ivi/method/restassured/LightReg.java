package ivi.method.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import ivi.SpecificationFactory;
import ivi.actions.restassured.ReadFileAsString;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class LightReg {
    String address;
    String token;
    String imei;
    String dealerId;
    String dealerAddressId;
    String creditor;

    public LightReg(String address, String token, String imei, String dealerId, String dealerAddressId
    , String creditor){
        this.address = address;
        this.token = token;
        this.imei = imei;
        this.dealerId = dealerId;
        this.dealerAddressId = dealerAddressId;
        this.creditor = creditor;
    }
    public void run(String file){
        String jsonBody = new ReadFileAsString("linkreg.json").run();

        JSONObject jsonObjectBody = new JSONObject(jsonBody);
        JSONArray array = jsonObjectBody.getJSONArray("products");
        JSONObject firstObject = array.getJSONObject(0);
        firstObject.put("imei", imei);
        jsonObjectBody.put("dealerId", dealerId);
        jsonObjectBody.put("dealerAddressId", dealerAddressId);
        jsonObjectBody.put("creditorId", creditor);

        String imei = JsonPath.from(jsonObjectBody.toString()).getString("products[0].imei");
        System.out.println(imei);
        System.out.println("---------------");
        System.out.println(jsonObjectBody);
        System.out.println("---------------");
        ResponseBody respBody = RestAssured.given()
                .spec(SpecificationFactory.reqSpec())
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + token)
                .body(jsonObjectBody.toString())
                .post(address + "/LightLoans")
                .then()
                .spec(SpecificationFactory.respSpec())
                .statusCode(200)
                .extract()
                .response()
                .body();
    }
}

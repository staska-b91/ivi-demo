package ivi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ivi.actions.Config;
import ivi.actions.restassured.ReadFileAsString;
import ivi.method.restassured.Authorization;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class RestAssuredTestRegSuccess {
    @Test
    public void testAuthRestAssured() throws IOException, URISyntaxException {
        Config config = new Config();
        String address = config.getAddressAPI();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();
        String dealerId = config.getDealerApi();
        String dealerAddress = config.getDealerAddressApi();
        String creditorExternalId = config.getCreditorExternalId();

        String token = new Authorization(address, clientId, clientSecret).run();//получение токена при автор-ции
        String jsonBody = new ReadFileAsString("linkreg.json").run();

        JSONObject jsonObjectBody = new JSONObject(jsonBody);
        JSONArray array = jsonObjectBody.getJSONArray("products");
        JSONObject firstObject = array.getJSONObject(0);
        firstObject.put("imei", "354566516866318");
        jsonObjectBody.put("dealerId", dealerId);
        jsonObjectBody.put("dealerAddressId", dealerAddress);
        jsonObjectBody.put("creditorId", creditorExternalId);

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

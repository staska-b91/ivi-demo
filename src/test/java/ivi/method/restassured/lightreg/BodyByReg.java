package ivi.method.restassured.lightreg;

import ivi.actions.restassured.ReadFileAsString;
import org.json.JSONArray;
import org.json.JSONObject;

public class BodyByReg {
    private String imei;
    private String dealerId;
    private String dealerAddressId;
    private String creditor;

    public BodyByReg(String imei, String dealerId, String dealerAddressId,
                     String creditor){
        this.imei = imei;
        this.dealerId = dealerId;
        this.dealerAddressId = dealerAddressId;
        this.creditor = creditor;
    }
    public String getBody(String file){
        String jsonBody = new ReadFileAsString(file).run();

        JSONObject jsonObjectBody = new JSONObject(jsonBody);
        JSONArray array = jsonObjectBody.getJSONArray("products");
        JSONObject firstObject = array.getJSONObject(0);
        firstObject.put("imei", imei);
        jsonObjectBody.put("dealerId", dealerId);
        jsonObjectBody.put("dealerAddressId", dealerAddressId);
        jsonObjectBody.put("creditorId", creditor);

        return jsonObjectBody.toString();
    }
}

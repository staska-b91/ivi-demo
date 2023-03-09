package ivi.method.restassured.auth;

import java.util.HashMap;
import java.util.Map;

public class AbstractAuth {

    public String getUrl(){
        return "/api/OAuth/access-token";
    }
    public Map<String, String> getHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
}

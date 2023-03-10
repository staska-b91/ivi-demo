package ivi.method.restassured.lightreg;

import java.util.HashMap;
import java.util.Map;

public class AbstractReg {
    public String getUrl(){
        return "/LightLoans";
    }
    public Map<String, String> getHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
}

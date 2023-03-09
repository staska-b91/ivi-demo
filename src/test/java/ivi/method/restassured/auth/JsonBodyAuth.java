package ivi.method.restassured.auth;

import org.json.JSONObject;

/**
 * метод реализует авторизацию в АПИ и получение токена
 */
public class JsonBodyAuth {
    private String clientId;
    private String clientSecret;

    public JsonBodyAuth(String clientId, String clientSecret){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getBody() {
        //создание json для rq
        JSONObject requestBody = new JSONObject();
        requestBody.put("clientId", clientId);
        requestBody.put("clientSecret", clientSecret);

        return requestBody.toString();
    }
//    public Response takeResponse(RequestSpecification request) {
//        1 rq
//        RequestSpecification request = RestAssured.given()
//                .spec(SpecificationFactory.reqSpec())
//                .header("Content-Type", "application/json")
//                .body(requestBody.toString());
//        2 url
//        String url = address + "/api/OAuth/access-token";
//        3 rs
//        Response response = request
//                .post(url)
//                .then()
//                .spec(SpecificationFactory.respSpec())
//                .extract()
//                .response();
//        return response;
//    }
//    public void assertStatusResponseSuccess(Response response) {
//        4 assert status
//        Assert.assertEquals(response.statusCode(), 200);
//    }
//    public String takeTokenFromPesponseBody(Response response) {
//        5 read body from class model
//        ResponseBody respBody = response.body();
//        UserTokenApiRequest bodyModel = respBody.as((Type) UserTokenApiRequest.class);
//        Assert.assertNotNull(bodyModel.getAccessToken());
//        получение токена из rs body
//        String token = bodyModel.getAccessToken();
//        System.out.println("-------------");
//        System.out.println("ТОКЕН ПОЛУЧЕН");
//        System.out.println("-------------");
//        return token;
//    }
}

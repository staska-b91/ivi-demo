package ivi.method;

import com.fasterxml.jackson.databind.ObjectMapper;
import ivi.request.UserAuthorizationInApiModel;
import okhttp3.*;
import org.junit.Assert;

import java.io.IOException;

public class APIAuthorization {
    private String clientId;
    private String clientSecret;
    private String address;
    private int responseCode;
    private String token;

    public APIAuthorization(String address, String clientId, String clientSecret) {
        this.address = address;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public void run() throws IOException {
        OkHttpClient client = new OkHttpClient();

        UserAuthorizationInApiModel model = new ObjectMapper()
                .readValue(UserAuthorizationInApiModel.class.getResourceAsStream("/auth.json"), UserAuthorizationInApiModel.class);

        model.setClientId(clientId);
        model.setClientSecret(clientSecret);

        RequestBody body = RequestBody.create(
                new ObjectMapper().writeValueAsString(model),
                MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(address + "/api/OAuth/access-token")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        responseCode = response.code();
        System.out.println("response code is - " + responseCode);
        //проверка на 500 ошибки
        // на 400 ошибку
        String jsonString = response.body().string();
        //действия если запрос успешен
        if (responseCode == 200){
            rqAuthModel resp200 = new ObjectMapper().readValue(jsonString, rqAuthModel.class);
            Assert.assertNotNull(resp200.getAccessToken());
            token = resp200.getAccessToken();
            System.out.println("token - " + token);
        } else {//если запрос возвращает 500 ошибку
            System.out.println(jsonString);
        }
    }
    static class rqAuthModel {
        String accessToken;
        String tokenType;
        int expiresIn;

        public String getAccessToken() {
            return accessToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public int getExpiresIn() {
            return expiresIn;
        }
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getToken() {
        return token;
    }
}

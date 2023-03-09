package ivi.response;

public class UserTokenApiRequest {
    private String accessToken;
    private String tokenType;
    private String expiresIn;

    public String getExpiresIn() {
        return expiresIn;
    }
    public String getTokenType() {
        return tokenType;
    }
    public String getAccessToken() {
        return accessToken;
    }
}

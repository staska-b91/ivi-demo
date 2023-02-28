package ivi;

import ivi.actions.Config;
import ivi.method.restassured.Authorization;
import org.junit.Test;

public class RestAssuredTestAuth {
    @Test
    public void testAuthRestAssured(){
        Config config = new Config();
        String address = config.getAddressApi();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();

        String token = new Authorization(address, clientId, clientSecret).run();//получение токена при автор-ции
    }
}

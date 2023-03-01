package ivi;

import ivi.actions.Config;
import ivi.method.restassured.Authorization;
import ivi.method.restassured.LightReg;
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
        String imei = config.getImei();

        String token = new Authorization(address, clientId, clientSecret).run();//получение токена при автор-ции
        new LightReg(address, token, imei, dealerId, dealerAddress, creditorExternalId).run("linkreg.json");
    }
}

package ivi.actions;

import static java.util.Objects.requireNonNull;

/**
 * Класс для получения значений параметров из переменных
 */
public class Config {

    public String getLogin() {
        return requireNonNull(System.getProperty("USER_NAME"),
                "Необходимо указать параметр -DUSER_NAME");
    }
    public String getPassword() {
        return requireNonNull(System.getProperty("PASSWORD_NAME"),
                "Необходимо указать параметр -DPASSWORD_NAME");
    }
    public String getClientId() {
        return requireNonNull(System.getProperty("CLIENT_ID"),
                "Необходимо указать параметр -DCLIENT_ID");
    }
    public String getClientSecret() {
        return requireNonNull(System.getProperty("CLIENT_SECRET"),
                "Необходимо указать параметр -DCLIENT_SECRET");
    }
    public String getAddressAPI() {
        return requireNonNull(System.getProperty("ADDRESS_API"),
                "Необходимо указать параметр -DADDRESS_API");
    }
    public String getDealerApi() {
        return requireNonNull(System.getProperty("DEALER_API"),
                "Необходимо указать параметр -DDEALER_API");
    }
    public String getDealerAddressApi() {
        return requireNonNull(System.getProperty("DEALER_ADDRESS_API"),
                "Необходимо указать параметр -DDEALER_ADDRESS_API");
    }
    public String getCreditorExternalId() {
        return requireNonNull(System.getProperty("CREDITOR_EXTERNAL_ID"),
                "Необходимо указать параметр -DCREDITOR_EXTERNAL_ID");
    }
    public String getImei() {
        return requireNonNull(System.getProperty("IMEI"),
                "Необходимо указать параметр -DIMEI");
    }
}

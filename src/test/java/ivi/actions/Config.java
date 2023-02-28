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
    public String getAddressApi() {
        return requireNonNull(System.getProperty("SERVIS_ADDRESS"),
                "Необходимо указать параметр -DSERVIS_ADDRESS");
    }
    public String getClientId() {
        return requireNonNull(System.getProperty("CLIENT_ID"),
                "Необходимо указать параметр -DCLIENT_ID");
    }
    public String getClientSecret() {
        return requireNonNull(System.getProperty("CLIENT_SECRET"),
                "Необходимо указать параметр -DCLIENT_SECRET");
    }
}

package ivi.actions.restassured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * метод создает String на основе файла json в resources
 */
public class ReadFileAsString {
    String file;

    public ReadFileAsString(String file) {
        this.file = file;
    }

    public String run() {
        String json = null;
        try {
            String fullFile = "src/test/resources/" + file;
            json = new String(Files.readAllBytes(Paths.get(fullFile)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

}

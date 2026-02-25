package session2.exercise4_3.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties = new Properties();
            properties.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl(){
        return get("url4.3");
    }
}
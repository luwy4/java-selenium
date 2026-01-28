package test;

import base.BaseTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;

public class FirstTest extends BaseTest {

    @Test
    public void openBrowserWithConfig() throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        String url = prop.getProperty("url1");

        driver.get(url);
    }
}
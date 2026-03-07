package session2.exercise3_4.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    public void setup() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url3.4"));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

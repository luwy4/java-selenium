package session2.exercise4_1.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import session2.exercise4_1.utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {

        String url = ConfigReader.getProperty("url4.1");
        String timeout = ConfigReader.getProperty("timeout");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(timeout)));

        driver.get(url);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
package session2.exercise4_3.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import session2.exercise4_3.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
package session3.exercise5_1.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session3.exercise5_1.pages.DashboardPage;
import session3.exercise5_1.pages.LoginPage;
import session3.exercise5_1.utils.ConfigReader;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
    }

    @Test
    public void testSuccessfulLogin_FluentStyle() {
        DashboardPage dashboard = new LoginPage(driver)
                .enterUsername(ConfigReader.getUsername())
                .enterPassword(ConfigReader.getPassword())
                .clickSubmit();

        Assert.assertTrue(dashboard.isLoginSuccessful());
        Assert.assertEquals(dashboard.getSuccessMessage().trim(),
                "Logged In Successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
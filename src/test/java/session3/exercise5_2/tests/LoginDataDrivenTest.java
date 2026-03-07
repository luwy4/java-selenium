package session3.exercise5_2.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session3.exercise5_2.data.LoginDataProvider;
import session3.exercise5_2.pages.LoginPage;

import java.time.Duration;

public class LoginDataDrivenTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void testLoginWithInlineData(String username, String password, boolean expected) {
        boolean actual = new LoginPage(driver).open().login(username, password).isLoginSuccessful();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "loginDataFromCsv", dataProviderClass = LoginDataProvider.class)
    public void testLoginWithCsv(String username, String password, boolean expected) {
        boolean actual = new LoginPage(driver).open().login(username, password).isLoginSuccessful();
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

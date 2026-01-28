package session1.exercise1_3.tests;

import base.BaseTest;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import session1.exercise1_3.pages.LoginPage;
import session1.utils.ConfigReader;
import session1.utils.WindowUtils;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginSuccessAndHandleTabs() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigReader.get("url1.3"));

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        Assert.assertEquals(loginPage.getSuccessMessage(), ConfigReader.get("expectedSuccessMessage"));

        String mainTab = WindowUtils.getCurrentWindow(driver);
        String currentUrl = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(currentUrl);

        Assert.assertEquals(loginPage.getSuccessMessage(), ConfigReader.get("expectedSuccessMessage"));

        WindowUtils.closeCurrentWindow(driver);
        WindowUtils.switchToWindow(driver, mainTab);

        Assert.assertEquals(driver.getWindowHandle(), mainTab);
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigReader.get("url1.3"));

        loginPage.login(ConfigReader.get("invalidUsername"), ConfigReader.get("invalidPassword"));

        String actualError = loginPage.getErrorMessage();

        Assert.assertTrue(actualError.contains(ConfigReader.get("expectedErrorMessage")), "Error message mismatch! Expected to contain: " + ConfigReader.get("expectedErrorMessage"));
    }
}
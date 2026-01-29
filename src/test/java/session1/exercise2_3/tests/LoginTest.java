package session1.exercise2_3.tests;

import base.BaseTest;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import session1.exercise2_3.pages.SuccessPage;
import session1.exercise2_3.pages.LoginPage;
import session1.utils.ConfigReader;
import session1.utils.WindowUtils;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginSuccessAndHandleTabs() {

        driver.get(ConfigReader.get("url1.3"));

        LoginPage loginPage = new LoginPage(driver);
        SuccessPage successPage = loginPage.loginSuccessfully(ConfigReader.get("username"), ConfigReader.get("password"));

        Assert.assertEquals(successPage.getSuccessText(), ConfigReader.get("expectedSuccessMessage"));

        String mainTab = WindowUtils.getCurrentWindow(driver);
        String currentUrl = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(currentUrl);

        SuccessPage newTabSuccess = new SuccessPage(driver);

        Assert.assertEquals(newTabSuccess.getSuccessText(), ConfigReader.get("expectedSuccessMessage"));

        WindowUtils.closeCurrentWindow(driver);
        WindowUtils.switchToWindow(driver, mainTab);

        Assert.assertEquals(driver.getWindowHandle(), mainTab);
    }

    @Test(priority = 2)
    public void testInvalidUsername() {

        driver.get(ConfigReader.get("url1.3"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.get("invalidUsername"), ConfigReader.get("password"));

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains(ConfigReader.get("expectedErrorMessage")));
    }

    @Test(priority = 3)
    public void testInvalidPassword() {

        driver.get(ConfigReader.get("url1.3"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("invalidPassword"));

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains(ConfigReader.get("expectedPasswordErrorMessage")));
    }
}
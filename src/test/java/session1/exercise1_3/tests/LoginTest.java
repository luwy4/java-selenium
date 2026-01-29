package session1.exercise1_3.tests;

import base.BaseTest;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import session1.exercise1_3.pages.LoginPage;
import session1.utils.ConfigReader;
import session1.utils.WindowUtils;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginAndHandleTabs() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigReader.get("url1.3"));

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        String mainTab = WindowUtils.getCurrentWindow(driver);
        String currentUrl = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(currentUrl);

        Assert.assertEquals(loginPage.getSuccessMessage(), ConfigReader.get("expectedSuccessMessage"));

        WindowUtils.closeCurrentWindow(driver);
        WindowUtils.switchToWindow(driver, mainTab);

        Assert.assertEquals(driver.getWindowHandle(), mainTab);
    }
}
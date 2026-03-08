package session3.exercise5_2.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session3.exercise5_2.data.LoginDataProvider;
import session3.exercise5_2.pages.LoginPage;

public class LoginDataDrivenTest extends BaseTest {

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

}

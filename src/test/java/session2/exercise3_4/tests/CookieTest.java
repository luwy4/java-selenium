package session2.exercise3_4.tests;



import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import session2.exercise3_4.base.BaseTest;
import session2.exercise3_4.pages.LoginPage;
import session2.exercise3_4.utils.CookieUtils;


public class CookieTest extends BaseTest {

    @Test
    public void testCookieSession() throws Exception {

        setup();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(prop.getProperty("username3.4"), prop.getProperty("password3.4"));


        Cookie cookie = new Cookie("username", "student");
        driver.manage().addCookie(cookie);

        Cookie getCookie = driver.manage().getCookieNamed("username");
        System.out.println("Cookie value = " + getCookie.getValue());

        driver.manage().deleteCookieNamed("username");


        CookieUtils.saveCookies(driver, prop.getProperty("cookieFile"));

        driver.quit();

        setup();

        CookieUtils.loadCookies(driver, prop.getProperty("cookieFile"));

        driver.navigate().refresh();

        System.out.println("Session restored!");

        tearDown();
    }
}

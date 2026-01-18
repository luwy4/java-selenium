package session1.exercise1_4.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import session1.utils.ConfigReader;
import session1.exercise1_4.locators.DynamicLoadingLocators;
import session1.exercise1_4.pages.DynamicLoadingPage;
import session1.utils.CustomWaitUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testLoading() {
        driver.get(ConfigReader.get("url1.4"));

        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        String expected = ConfigReader.get("expected_success_msg");

        int timeoutValue = Integer.parseInt(ConfigReader.get("timeout"));

        page.clickStart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutValue));
        wait.until(CustomWaitUtils.loadingFinished(
                DynamicLoadingLocators.LOADING_BAR,
                DynamicLoadingLocators.FINISH_TEXT,
                expected
        ));

        String actual = driver.findElement(DynamicLoadingLocators.FINISH_TEXT).getText();
        Assert.assertEquals(actual, expected);
    }
}
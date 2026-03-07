package session2.exercise3_1.tests;


import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import session1.utils.ConfigReader;
import session2.exercise3_1.pages.AdvancedActionsPage;

public class AdvancedActionsTest extends BaseTest {

    @Test
    public void testAdvancedActionChains() {

        AdvancedActionsPage advancedPage = new AdvancedActionsPage(driver);
        driver.get(ConfigReader.get("url3.1"));

        advancedPage.ctrlClickOnDynamicButton();

        advancedPage.hoverPauseAndClick();

        advancedPage.shiftDoubleClick();

        advancedPage.clickAndHoldDynamicButton();

        advancedPage.pressEnterKey();

        String message = driver.findElement(By.id("dynamicClickMessage")).getText();

        Assert.assertTrue(message.contains("dynamic click"));
    }
}

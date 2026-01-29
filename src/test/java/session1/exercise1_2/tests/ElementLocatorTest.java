package session1.exercise1_2.tests;

import org.testng.annotations.Test;
import base.BaseTest;
import session1.exercise1_2.locators.ElementLocators;
import session1.utils.ConfigReader;

public class ElementLocatorTest extends BaseTest {
    @Test
    public void verifyLocatorStrategies() throws InterruptedException {
        driver.get(ConfigReader.get("url2"));
        driver.findElement(ElementLocators.TEXT_BOX_MENU).click();
        Thread.sleep(1000);
        driver.findElement(ElementLocators.FULL_NAME_INPUT).sendKeys("Le Vy");
        driver.findElement(ElementLocators.EMAIL_INPUT).sendKeys("levy@gmail.com");
        driver.findElement(ElementLocators.CURRENT_ADDRESS_TEXTAREA).sendKeys("Ha Noi");
        driver.findElement(ElementLocators.PERMANENT_ADDRESS_TEXTAREA).sendKeys("Vietnam");

        Thread.sleep(2000);
    }
}

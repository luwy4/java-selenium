package session1.exercise1_2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import session1.exercise1_2.locators.ElementLocators;
import session1.utils.ConfigReader;

public class ElementLocatorTest extends BaseTest {
    @Test
    public void verifyLocatorStrategies() {
        driver.get(ConfigReader.get("url2"));

        WebElement menu = driver.findElement(By.xpath(String.format(ElementLocators.DYNAMIC_MENU, ConfigReader.get("menu_text"))));
        menu.click();

        driver.findElement(ElementLocators.ID_NAME).sendKeys(ConfigReader.get("user_name"));
        driver.findElement(ElementLocators.ID_EMAIL).sendKeys(ConfigReader.get("user_email"));
        driver.findElement(ElementLocators.ID_CURRENT_ADDR).sendKeys(ConfigReader.get("current_addr"));
        driver.findElement(ElementLocators.ID_PERMANENT_ADDR).sendKeys(ConfigReader.get("permanent_addr"));

        WebElement btnSubmit = driver.findElement(ElementLocators.BTN_SUBMIT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSubmit);

        driver.findElement(ElementLocators.XPATH_LABEL_NAME).isDisplayed();
        driver.findElement(ElementLocators.CSS_OUTPUT_NAME).isDisplayed();
        driver.findElement(ElementLocators.CSS_OUTPUT_EMAIL).isDisplayed();

        findElement(ElementLocators.DYNAMIC_OUTPUT, "currentAddress").isDisplayed();
        findElement(ElementLocators.DYNAMIC_OUTPUT, "permanentAddress").isDisplayed();
    }
}
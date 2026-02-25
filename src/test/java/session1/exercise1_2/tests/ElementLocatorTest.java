package session1.exercise1_2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session1.exercise1_2.locators.ElementLocators;
import session1.utils.ConfigReader;

import java.time.Duration;

public class ElementLocatorTest extends BaseTest {

    @Test
    public void verifyLocatorStrategies() {
        driver.get(ConfigReader.get("url2"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(ElementLocators.MENU_ITEM, ConfigReader.get("menu_text")))));
        menu.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(ElementLocators.ID, "userName"))));

        getElement(ElementLocators.ID, "userName").sendKeys(ConfigReader.get("user_name"));
        getElement(ElementLocators.ID, "userEmail").sendKeys(ConfigReader.get("user_email"));
        getElement(ElementLocators.ID, "currentAddress").sendKeys(ConfigReader.get("current_addr"));
        getElement(ElementLocators.ID, "permanentAddress").sendKeys(ConfigReader.get("permanent_addr"));

        WebElement btnSubmit = getElement(ElementLocators.BTN_BY_TEXT, ConfigReader.get("btn_submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSubmit);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ElementLocators.CLASS_OUTPUT_BOX)));

        getElement(ElementLocators.LABEL_BY_TEXT, ConfigReader.get("label_full_name")).isDisplayed();
        getElement(ElementLocators.OUTPUT_FIELD, "name").isDisplayed();
        getElement(ElementLocators.OUTPUT_FIELD, "email").isDisplayed();
    }

    private WebElement getElement(String locator, String value) {
        String formatted = String.format(locator, value);
        if (formatted.startsWith("//") || formatted.startsWith("(//")) {
            return driver.findElement(By.xpath(formatted));
        }
        return driver.findElement(By.cssSelector(formatted));
    }
}
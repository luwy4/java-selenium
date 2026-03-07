package session3.exercise5_1.base;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import session3.exercise5_1.utils.ConfigReader;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
    }

    // ── Core wait methods ───────────────────────────────────────────────
    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ── Common actions ──────────────────────────────────────────────────
    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    protected void selectByVisibleText(By locator, String visibleText) {
        WebElement element = waitForVisible(locator);
        new Select(element).selectByVisibleText(visibleText);
    }

    protected void selectByValue(By locator, String value) {
        WebElement element = waitForVisible(locator);
        new Select(element).selectByValue(value);
    }

    // Optional: navigate
    protected void navigateTo(String url) {
        driver.get(url);
    }
}
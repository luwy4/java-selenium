package session3.exercise5_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session3.exercise5_1.utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class AccessibilityPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By allFormControls = By.cssSelector("form input, form button, form select, form textarea");

    public AccessibilityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public AccessibilityPage open() {
        driver.get(ConfigReader.getProperty("url5.3"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        return this;
    }

    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public List<WebElement> getInteractiveElements() {
        return driver.findElements(allFormControls);
    }
}

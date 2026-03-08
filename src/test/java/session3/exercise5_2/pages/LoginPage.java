package session3.exercise5_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session3.exercise5_1.utils.ConfigReader;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By successTitle = By.className("post-title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public LoginPage open() {
        driver.get(ConfigReader.getProperty("url5.2"));
        return this;
    }

    public LoginPage login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
        driver.findElement(usernameField).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(successTitle));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }
}

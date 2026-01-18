package session1.exercise1_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session1.exercise1_3.locators.LoginLocators;

import java.time.Duration;
import java.util.Set;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.USERNAME_FIELD)).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.PASSWORD_FIELD)).sendKeys(pass);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.SUBMIT_BUTTON)).click();

    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.SUCCESS_MESSAGE)).getText();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickSubmit();
    }

}
